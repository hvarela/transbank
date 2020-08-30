package com.prueba.transbank.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.prueba.transbank.domain.entities.error.InvalidTokenException;
import com.prueba.transbank.domain.usecase.port.JwtTokenDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.time.ZonedDateTime.now;

@Component
public class JwtTokenManager implements JwtTokenDataProvider {

    Logger looger = LoggerFactory.getLogger(JwtTokenManager.class);

    private static final String USER_CLAIM = "user";
    private static final String ISSUER = "transbank";


    private AlgorithmKeyManager algorithmKeyManager;

    private JWTVerifier jwtVerifier;

    public JwtTokenManager(AlgorithmKeyManager algorithmKeyManager){
        this.algorithmKeyManager = algorithmKeyManager;
        this.jwtVerifier = JWT.require(algorithmKeyManager.getAlgorithm()).build();
    }

    @Override
    public String generateToken(String user, int ttl) {
        Date expTime = new Date(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(ttl));

        return JWT.create()
                .withIssuer(ISSUER)
                .withClaim(USER_CLAIM, user)
                .withIssuedAt(Date.from(now().toInstant()))
                .withExpiresAt(expTime)
                .sign(algorithmKeyManager.getAlgorithm());
    }

    @Override
    public boolean isValidToken(String token) {
        try {

            DecodedJWT verify = jwtVerifier.verify(token);

        } catch (AlgorithmMismatchException | SignatureVerificationException | InvalidClaimException | TokenExpiredException ex) {
            looger.error( String.format("invalid token : %s", ex.getMessage()));
            throw new InvalidTokenException();
        }
        return true;
    }

}
