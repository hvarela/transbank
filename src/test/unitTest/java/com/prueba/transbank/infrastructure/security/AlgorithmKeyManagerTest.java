package com.prueba.transbank.infrastructure.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:secrets/secret.properties")
public class AlgorithmKeyManagerTest {

    private AlgorithmKeyManager algorithmKeyManager;

    @Value("${jwt.keys.hmac}")
    private String hma;

    @Before
    public void init(){
        algorithmKeyManager = new AlgorithmKeyManager(hma);
    }

    @Test
    public void veryfiAlgorithm(){

        assertEquals("HS512", algorithmKeyManager.getAlgorithm().getName());
    }


}
