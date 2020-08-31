package com.prueba.transbank.infrastructure.entrypoints.translator;

import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.LoginRequest;

public class UserRequestTranslator {

    public static User translate(LoginRequest loginRequest){
        return   new User(loginRequest.getName(), loginRequest.getPassword());
    }
}
