package com.prueba.transbank.infrastructure.security;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Component
public class JwtKeyManager  {

    private final Algorithm algorithm;

    @Autowired
    public JwtKeyManager(@Value("${jwt.keys.hmac}") String hmac) {
        this(Base64.getDecoder().decode(hmac));
    }

    public JwtKeyManager(byte[] hmac) {
        this.algorithm = Algorithm.HMAC512(hmac);
    }

    public String generateHMAC512Key() throws NoSuchAlgorithmException {
        SecureRandom seedGenerator = SecureRandom.getInstance("SHA1PRNG");
        byte[] seed = seedGenerator.generateSeed(5);

        SecureRandom uidGenerator = SecureRandom.getInstance("SHA1PRNG");
        uidGenerator.setSeed(seed);

        byte[] key = new byte[128];

        uidGenerator.nextBytes(key);

        return Base64.getEncoder().encodeToString(key);
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

}
