package com.prueba.transbank.domain.usecase.port;

import com.prueba.transbank.domain.entities.user.User;

public interface VerifyLoginUserDataProvide {
    boolean loginUser(User user);
}
