package com.prueba.transbank.domain.usecase.port;

public interface JwtTokenDataProvider {

    String generateToken(String user, int ttl);
    boolean isValidToken(String token);

}
