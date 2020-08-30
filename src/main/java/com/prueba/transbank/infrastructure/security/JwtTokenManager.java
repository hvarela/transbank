package com.prueba.transbank.infrastructure.security;

import com.prueba.transbank.domain.usecase.port.JwtTokenDataProvider;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenManager implements JwtTokenDataProvider {

    private AlgorithmKeyManager algorithmKeyManager;

    public JwtTokenManager(AlgorithmKeyManager algorithmKeyManager){
        this.algorithmKeyManager = algorithmKeyManager;
    }

    @Override
    public String genereteToken(String key, int ttl) {

        return null;
    }

    @Override
    public boolean isValidToken(String token) {
        return false;
    }
}
