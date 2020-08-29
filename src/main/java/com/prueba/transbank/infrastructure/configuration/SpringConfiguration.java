package com.prueba.transbank.infrastructure.configuration;

import com.prueba.transbank.domain.usecase.LoginUser;
import com.prueba.transbank.infrastructure.repository.VerifyLoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {


    private VerifyLoginUserRepository verifyLoginUserRepository;

    @Autowired
    SpringConfiguration(VerifyLoginUserRepository verifyLoginUserRepository){
        this.verifyLoginUserRepository = verifyLoginUserRepository;
    }

    @Bean
    public LoginUser getLoginUserBean(){
        return   new LoginUser(verifyLoginUserRepository);
    }

}
