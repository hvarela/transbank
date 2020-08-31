package com.prueba.transbank.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.prueba.transbank.domain.entities.error.TokenIsExpiredException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class JwtTokenManagerTest {

    private JwtTokenManager jwtTokenManager;
    private static final String ISSUER ="test";

    @Before
    public  void init(){
        AlgorithmKeyManager algorithmKeyManager = new AlgorithmKeyManager("12312312313dsadafddsaqd");
        jwtTokenManager = new JwtTokenManager(algorithmKeyManager, 1, ISSUER);
    }

    @Test
    public void genereteToken()  {

        String token = jwtTokenManager.generateToken("tito1234");

        DecodedJWT decode = JWT.decode(token);

        assertEquals("tito1234",  decode.getClaim("user").asString());
        assertEquals(ISSUER,  decode.getIssuer());

    }

    @Test
    public void veryfyIfTokenIsValid()  {

        String token = jwtTokenManager.generateToken("tito1234");

        assertTrue(jwtTokenManager.isValidToken(token));

    }

    @Test(expected = TokenIsExpiredException.class)
    public void veryfyIfExpireToken() throws InterruptedException {

        String token = jwtTokenManager.generateToken("tito1234");

        TimeUnit.SECONDS.sleep(2);

        jwtTokenManager.isValidToken(token);

    }
}