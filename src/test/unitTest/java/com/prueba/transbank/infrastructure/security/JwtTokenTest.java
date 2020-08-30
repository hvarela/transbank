package com.prueba.transbank.infrastructure.security;

import com.auth0.jwt.JWT;
import org.apache.tomcat.jni.Time;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JwtTokenTest {

    private JwtToken jwtToken;
    private String key;

    @Mock
    private JwtKeyManager jwtKeyManager;

    @Before
    public  void init(){
        key="12345";
        jwtToken = new JwtToken(jwtKeyManager);
    }

    @Test
    public void genereteToken() throws NoSuchAlgorithmException {
        when( jwtKeyManager.generateHMAC512Key() ).thenReturn(key);

        String token = jwtToken.genereteToken("tito1234", 20);

        assertEquals(JWT.decode(token), "tito1234");

    }

    @Test
    public void veryfyIfTokenIsValid() throws NoSuchAlgorithmException {

        when( jwtKeyManager.generateHMAC512Key() ).thenReturn(key);

        String token = jwtToken.genereteToken("tito1234", 20);

        assertTrue(jwtToken.isValidToken(token));

    }

    @Test
    public void veryfyIfExpireToken() throws NoSuchAlgorithmException, InterruptedException {

        when( jwtKeyManager.generateHMAC512Key() ).thenReturn(key);

        String token = jwtToken.genereteToken("tito1234", 1);

        TimeUnit.SECONDS.sleep(3);

        assertFalse(jwtToken.isValidToken(token));

    }
}