package com.prueba.transbank.infrastructure.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:secrets/secret.properties")
public class AlgorithmEncryptPasswordTest {

    private AlgorithmEncryptPassword algorithmEncryptPassword;

    @Value("${algorithmEncryptpassword.salt}")
    private String salt;
    @Value("${algorithmEncryptpassword.keylength}")
    private int keyLength;
    @Value("${algorithmEncryptpassword.iterations}")
    private int iteration;
    @Value("${algorithmEncryptpassword.algorithm}")
    private String algorithm;

    @Before
    public  void init(){
        algorithmEncryptPassword = new AlgorithmEncryptPassword( salt, keyLength, iteration, algorithm);
    }

    @Test
    public void generateSecurePasswordTest() {

        String pass = algorithmEncryptPassword.generateSecurePassword("tito");

        assertTrue( pass != null && pass.length()>30);
    }
}
