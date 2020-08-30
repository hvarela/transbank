package com.prueba.transbank.infrastructure.configuration;

import com.prueba.transbank.domain.usecase.LoginUser;
import com.prueba.transbank.infrastructure.repository.VerifyLoginUserRepository;
import com.prueba.transbank.infrastructure.security.AlgorithmEncryptPassword;

import com.prueba.transbank.infrastructure.security.JwtTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {


    private VerifyLoginUserRepository verifyLoginUserRepository;
    private AlgorithmEncryptPassword algorithmEncryptPassword;
    private JwtTokenManager jwtTokenManager;

    @Autowired
    SpringConfiguration(VerifyLoginUserRepository verifyLoginUserRepository,
                        AlgorithmEncryptPassword algorithmEncryptPassword,
                        JwtTokenManager jwtTokenManager
                         ){
        this.verifyLoginUserRepository = verifyLoginUserRepository;
        this.algorithmEncryptPassword = algorithmEncryptPassword;
        this.jwtTokenManager = jwtTokenManager;
    }

    @Bean
    public LoginUser getLoginUserBean(){
        return   new LoginUser(verifyLoginUserRepository, algorithmEncryptPassword, jwtTokenManager);
    }

}
