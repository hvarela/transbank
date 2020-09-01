package com.prueba.transbank.infrastructure.entrypoints.rest.filter;

import com.prueba.transbank.domain.entities.error.InternalErrorException;
import com.prueba.transbank.domain.entities.error.InvalidTokenException;
import com.prueba.transbank.domain.entities.error.RequestWithoutTokenException;
import com.prueba.transbank.domain.entities.error.TokenIsExpiredException;
import com.prueba.transbank.infrastructure.security.JwtTokenManager;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ValidTokenInterceptorTest {

    @InjectMocks
    private ValidTokenInterceptor validTokenInterceptor;

    @Mock
    private JwtTokenManager jwtTokenManager;

    @Mock
    private FilterChain filterChain;

    @Mock
    private HandlerExceptionResolver resolver;

    @Before
    public void init(){

        ReflectionTestUtils.setField(validTokenInterceptor, "VALIDA_URL", Arrays.asList("/sales"));
        ReflectionTestUtils.setField(validTokenInterceptor, "resolver", resolver);
    }

    @Test
    public void  shouldAvoidValidadUrl() throws ServletException, IOException {

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();

        mockHttpServletRequest.setRequestURI("/tito");

        validTokenInterceptor.doFilterInternal(mockHttpServletRequest, mockHttpServletResponse, filterChain);

        verify(filterChain, times(1)).doFilter(any(HttpServletRequest.class) , any(HttpServletResponse.class));

    }

    @Test
    public void shouldThrowExceptionWhyRequestWithoutToken() throws ServletException, IOException {

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();

        mockHttpServletRequest.setRequestURI("/sales");

        validTokenInterceptor.doFilterInternal(mockHttpServletRequest, mockHttpServletResponse, filterChain);


        ArgumentCaptor<Exception> argumentCaptor = ArgumentCaptor.forClass(Exception.class);

        verify(resolver).resolveException( eq(mockHttpServletRequest), eq(mockHttpServletResponse), eq(null), argumentCaptor.capture());


        Exception value = argumentCaptor.getValue();

        assertTrue(value instanceof RequestWithoutTokenException);

    }



    @Test
    public void validTokenSuccessfuly() throws ServletException, IOException {

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();

        mockHttpServletRequest.setRequestURI("/sales");

        mockHttpServletRequest.addHeader("authorization","Bearer eeewqeqwqeq");


        when(jwtTokenManager.isValidToken(anyString())).thenReturn(true);


        validTokenInterceptor.doFilterInternal(mockHttpServletRequest, mockHttpServletResponse, filterChain);

        verify(filterChain, times(1)).doFilter(any(HttpServletRequest.class) , any(HttpServletResponse.class));

    }

}