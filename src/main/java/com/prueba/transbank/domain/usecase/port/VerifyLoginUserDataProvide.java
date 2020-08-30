package com.prueba.transbank.domain.usecase.port;

import com.prueba.transbank.domain.entities.user.User;

public interface VerifyLoginUserDataProvide {
    @Deprecated
    boolean loginUser(User user);
    boolean loginUser(String name, String encrytedPass);
}
