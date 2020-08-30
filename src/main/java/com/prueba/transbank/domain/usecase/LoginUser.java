package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.error.LoginErrorException;
import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.domain.usecase.port.AlgorithmEncryptPasswordDataProvide;
import com.prueba.transbank.domain.usecase.port.JwtTokenDataProvider;
import com.prueba.transbank.domain.usecase.port.VerifyLoginUserDataProvide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginUser {

    private Logger logger = LoggerFactory.getLogger(LoginUser.class);
    private VerifyLoginUserDataProvide verifyLoginUserDataProvide;
    private AlgorithmEncryptPasswordDataProvide algorithmEncryptPasswordDataProvide;
    private JwtTokenDataProvider jwtTokenDataProvider;

    public LoginUser(VerifyLoginUserDataProvide verifyLoginUserDataProvide,
                     AlgorithmEncryptPasswordDataProvide algorithmEncryptPasswordDataProvide,
                    JwtTokenDataProvider jwtTokenDataProvider){
        this.verifyLoginUserDataProvide = verifyLoginUserDataProvide;
        this.algorithmEncryptPasswordDataProvide = algorithmEncryptPasswordDataProvide;
        this.jwtTokenDataProvider = jwtTokenDataProvider;
    }

    public String login(User user){

        String token;

        if( verifyLoginUserDataProvide.loginUser(user.getName(), algorithmEncryptPasswordDataProvide.generateSecurePassword(user.getPassword()))){

            token = jwtTokenDataProvider.generateToken(user.getName());

            logger.info( String.format("usuario [%s]  logeado exitosamente ", user.getName()));

            return token;

        }else{
            logger.error( String.format("usuario [%s]  no esta en BD ", user.getName()));
            throw  new LoginErrorException();
        }
    }
}
