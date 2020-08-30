package com.prueba.transbank.infrastructure.security;

import com.prueba.transbank.domain.usecase.port.JwtTokenDataProvider;
import org.springframework.stereotype.Component;

@Component
public class JwtToken implements JwtTokenDataProvider {

    private JwtKeyManager jwtKeyManager;

    public JwtToken( JwtKeyManager jwtKeyManager){
        this.jwtKeyManager = jwtKeyManager;
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
