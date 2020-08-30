package com.prueba.transbank.infrastructure.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:secrets/secret.properties")
public class JwtKeyManagerTest {

    private JwtKeyManager jwtKeyManager;

    @Value("${jwt.keys.hmac}")
    private String hma;

    @Before
    public void init(){
        jwtKeyManager = new JwtKeyManager(hma);
    }

    @Test
    public void veryfiAlgorithm(){
        assertEquals("HS512", jwtKeyManager.getAlgorithm().getName());
    }

    @Test
    public void veryfiGeneratedDistincToken() throws NoSuchAlgorithmException {

        String key1 = jwtKeyManager.generateHMAC512Key();
        String key2= jwtKeyManager.generateHMAC512Key();

        assertTrue( key1.length()>100);
        assertTrue( key2.length()>100);
        assertNotEquals(key1, key2);
    }
}
