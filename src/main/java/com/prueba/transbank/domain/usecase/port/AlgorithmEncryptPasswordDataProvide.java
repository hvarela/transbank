package com.prueba.transbank.domain.usecase.port;

public interface AlgorithmEncryptPasswordDataProvide {
    String  generateSecurePassword(String password);
}
