package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.domain.usecase.port.VerifyLoginUserDataProvide;

public class LoginUser {

    private VerifyLoginUserDataProvide verifyLoginUserDataProvide;

    public LoginUser(VerifyLoginUserDataProvide verifyLoginUserDataProvide){
        this.verifyLoginUserDataProvide = verifyLoginUserDataProvide;
    }

    public boolean login(User user){

        return  verifyLoginUserDataProvide.loginUser(user);

    }
}
