package com.prueba.transbank.infrastructure.security;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class AlgorithmKeyManager {

    private final Algorithm algorithm;

    @Autowired
    public AlgorithmKeyManager(@Value("${jwt.keys.hmac}") String hmac) {
        this(Base64.getDecoder().decode(hmac));

    }

    private AlgorithmKeyManager(byte[] hmac) {

        this.algorithm = Algorithm.HMAC512(hmac);
    }


    public Algorithm getAlgorithm() {
        return algorithm;
    }

}
