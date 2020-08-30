package com.prueba.transbank.domain.usecase.port;

public interface JwtTokenDataProvider {

    String generateToken(String user);
    boolean isValidToken(String token);

}
