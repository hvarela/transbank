package com.prueba.transbank.infrastructure.entrypoints.rest.translator;

import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.UserRequest;

public class UserRequestTranslator {

    public static User translate(UserRequest userRequest){
        return   new User(userRequest.getName(), userRequest.getPassword());
    }
}
