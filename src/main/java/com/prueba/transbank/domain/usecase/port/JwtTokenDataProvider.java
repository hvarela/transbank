package com.prueba.transbank.domain.usecase.port;

public interface JwtTokenDataProvider {

    String genereteToken(String key, int ttl);
    boolean isValidToken(String token);
}
