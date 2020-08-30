package com.prueba.transbank.domain.usecase.port;

public interface VerifyLoginUserDataProvide {
    boolean loginUser(String name, String encrytedPass);
}
