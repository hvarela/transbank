package com.prueba.transbank.infrastructure.entrypoints.rest.filter;


import com.prueba.transbank.domain.entities.error.RequestWithoutTokenException;
import com.prueba.transbank.infrastructure.security.JwtTokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Component
@Order(1)
public class ValidTokenInterceptor extends OncePerRequestFilter {

    private static  final String BEARER = "Bearer ";
    private static final Logger logger = LoggerFactory.getLogger(ValidTokenInterceptor.class);

    @Value("#{T(java.util.Arrays).asList('${trackingDataFilter.toValidaPath:}')}")
    private List<String> VALIDA_URL;

    private JwtTokenManager jwtTokenManager;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    ValidTokenInterceptor(JwtTokenManager jwtTokenManager){
        this.jwtTokenManager = jwtTokenManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.debug("Validating  url");
        if (!checkValidaTokenToRequestUrl(request.getRequestURI())) {
            filterChain.doFilter(request, response);
        } else {
            logger.debug("Validating  bearer token");

            String bearer = request.getHeader("authorization");


            try {
                if(StringUtils.isEmpty(bearer) || !bearer.contains(BEARER)){
                    throw  new RequestWithoutTokenException();
                }

                jwtTokenManager.isValidToken(bearer.substring(BEARER.length()));


            } catch (Exception e) {
                logger.error("Spring Security Filter Chain Exception:", e);
                resolver.resolveException(request, response, null, e);
                return;
            }

            logger.debug("token validado ok");

            filterChain.doFilter(request, response);

        }
    }


    public boolean checkValidaTokenToRequestUrl(String requestUrl) {
        return VALIDA_URL.stream().anyMatch(entry -> requestUrl.contains(entry));
    }

}
