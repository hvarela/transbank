package com.prueba.transbank.infrastructure.security;

import com.prueba.transbank.domain.usecase.port.AlgorithmEncryptPasswordDataProvide;
import com.prueba.transbank.infrastructure.repository.VerifyLoginUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

@Component
public class AlgorithmEncryptPassword implements AlgorithmEncryptPasswordDataProvide {

    private Logger logger = LoggerFactory.getLogger(AlgorithmEncryptPassword.class);


    private  String  salt;
    private  int keyLength;
    private  int iteration;
    private String algorithm;

    public AlgorithmEncryptPassword(  @Value("${algorithmEncryptpassword.salt}") String salt,
                                      @Value("${algorithmEncryptpassword.keylength}") int keyLength,
                                      @Value("${algorithmEncryptpassword.iterations}") int iteration,
                                      @Value("${algorithmEncryptpassword.algorithm}") String algorithm
                                      ){
        this.salt = salt;
        this.keyLength = keyLength;
        this.iteration = iteration;
        this.algorithm = algorithm;
    }

    private  byte[] hash(char[] password) {
        PBEKeySpec spec = new PBEKeySpec(password,  salt.getBytes(), iteration, keyLength);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }


    @Override
    public String generateSecurePassword(String password) {
        String returnValue = null;


        byte[] securePassword = hash(password.toCharArray());

        returnValue = Base64.getEncoder().encodeToString(securePassword);

        return returnValue;
    }
}