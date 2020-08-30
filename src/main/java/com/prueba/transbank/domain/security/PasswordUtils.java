package com.prueba.transbank.domain.security;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

public class PasswordUtils {

    private  static final String  SALT="pruebaTL";
    private static final int KEY_LENGTH = 512;
    private static final int ITERATIONS = 10000;

    private static byte[] hash(char[] password) {
        PBEKeySpec spec = new PBEKeySpec(password,  SALT.getBytes(), ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    public static String generateSecurePassword(String password) {
        String returnValue = null;


        byte[] securePassword = hash(password.toCharArray());

        returnValue = Base64.getEncoder().encodeToString(securePassword);

        return returnValue;
    }


}