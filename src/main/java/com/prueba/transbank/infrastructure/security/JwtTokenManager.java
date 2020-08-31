package com.prueba.transbank.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.*;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.prueba.transbank.domain.entities.error.InvalidTokenException;
import com.prueba.transbank.domain.entities.error.TokenIsExpiredException;
import com.prueba.transbank.domain.usecase.port.JwtTokenDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.time.ZonedDateTime.now;

@Component
public class JwtTokenManager implements JwtTokenDataProvider {

    Logger looger = LoggerFactory.getLogger(JwtTokenManager.class);

    private static final String USER_CLAIM = "user";
    private  String issuer;
    private int ttl;

    private AlgorithmKeyManager algorithmKeyManager;

    private JWTVerifier jwtVerifier;

    public JwtTokenManager(AlgorithmKeyManager algorithmKeyManager, @Value("${jwt.keys.ttl}") int ttl,  @Value("${jwt.keys.issuer}") String issuer){
        this.algorithmKeyManager = algorithmKeyManager;
        this.jwtVerifier = JWT.require(algorithmKeyManager.getAlgorithm()).build();
        this.ttl= ttl;
        this.issuer = issuer;
    }

    @Override
    public String generateToken(String user) {
        Date expTime = new Date(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(ttl));

        return JWT.create()
                .withIssuer(issuer)
                .withClaim(USER_CLAIM, user)
                .withIssuedAt(Date.from(now().toInstant()))
                .withExpiresAt(expTime)
                .sign(algorithmKeyManager.getAlgorithm());
    }

    @Override
    public boolean isValidToken(String token) {
        try {

            DecodedJWT verify = jwtVerifier.verify(token);

        } catch (AlgorithmMismatchException | JWTDecodeException |SignatureVerificationException | InvalidClaimException ex) {
            looger.error( String.format("invalid token : %s", ex.getMessage()));
            throw new InvalidTokenException();
        }catch( TokenExpiredException ex){
            looger.error( String.format("invalid token : %s", ex.getMessage()));
            throw new TokenIsExpiredException(ex.getMessage());
        }
        return true;
    }

}
