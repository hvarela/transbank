package com.prueba.transbank.infrastructure.security;

import com.auth0.jwt.JWT;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class JwtTokenManagerTest {

    private JwtTokenManager jwtTokenManager;
    private String key;
    private AlgorithmKeyManager algorithmKeyManager;

    @Before
    public  void init(){
        key="12345";
        algorithmKeyManager = new AlgorithmKeyManager("12312312313dsadafddsaqd");
        jwtTokenManager = new JwtTokenManager(algorithmKeyManager);
    }

    @Test
    public void genereteToken()  {

        String token = jwtTokenManager.genereteToken("tito1234", 20);

        assertEquals(JWT.decode(token), "tito1234");

    }

    @Test
    public void veryfyIfTokenIsValid()  {

        String token = jwtTokenManager.genereteToken("tito1234", 20);

        assertTrue(jwtTokenManager.isValidToken(token));

    }

    @Test
    public void veryfyIfExpireToken() throws NoSuchAlgorithmException, InterruptedException {

        String token = jwtTokenManager.genereteToken("tito1234", 1);

        TimeUnit.SECONDS.sleep(3);

        assertFalse(jwtTokenManager.isValidToken(token));

    }
}