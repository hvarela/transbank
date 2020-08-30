package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.error.LoginErrorException;
import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.domain.usecase.port.VerifyLoginUserDataProvide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginUser {

    private Logger logger = LoggerFactory.getLogger(LoginUser.class);
    private VerifyLoginUserDataProvide verifyLoginUserDataProvide;

    public LoginUser(VerifyLoginUserDataProvide verifyLoginUserDataProvide){
        this.verifyLoginUserDataProvide = verifyLoginUserDataProvide;
    }

    public boolean login(User user){

        if( verifyLoginUserDataProvide.loginUser(user)){
            logger.info("se encontro el usuario en BD");
            return true;
        }else{
            throw  new LoginErrorException();
        }
    }
}
