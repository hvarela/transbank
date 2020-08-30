package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.error.LoginErrorException;
import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.domain.usecase.port.AlgorithmEncryptPasswordDataProvide;
import com.prueba.transbank.domain.usecase.port.VerifyLoginUserDataProvide;
import com.prueba.transbank.infrastructure.security.AlgorithmEncryptPassword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginUser {

    private Logger logger = LoggerFactory.getLogger(LoginUser.class);
    private VerifyLoginUserDataProvide verifyLoginUserDataProvide;
    private AlgorithmEncryptPasswordDataProvide algorithmEncryptPasswordDataProvide;

    public LoginUser(VerifyLoginUserDataProvide verifyLoginUserDataProvide,
                     AlgorithmEncryptPasswordDataProvide algorithmEncryptPasswordDataProvide){
        this.verifyLoginUserDataProvide = verifyLoginUserDataProvide;
        this.algorithmEncryptPasswordDataProvide = algorithmEncryptPasswordDataProvide;
    }

    public boolean login(User user){

        if( verifyLoginUserDataProvide.loginUser(user.getName(), algorithmEncryptPasswordDataProvide.generateSecurePassword(user.getPassword()))){
            logger.info("se encontro el usuario en BD");
            return true;
        }else{
            throw  new LoginErrorException();
        }
    }
}
