package com.prueba.transbank.infrastructure.configuration;

import com.prueba.transbank.domain.usecase.LoginUser;
import com.prueba.transbank.domain.usecase.SalesRecords;
import com.prueba.transbank.infrastructure.repository.SalesRecordsRepository;
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
    private SalesRecordsRepository salesRecordsRepository;

    @Autowired
    SpringConfiguration(VerifyLoginUserRepository verifyLoginUserRepository,
                        AlgorithmEncryptPassword algorithmEncryptPassword,
                        JwtTokenManager jwtTokenManager,
                        SalesRecordsRepository salesRecordsRepository
                         ){
        this.verifyLoginUserRepository = verifyLoginUserRepository;
        this.algorithmEncryptPassword = algorithmEncryptPassword;
        this.jwtTokenManager = jwtTokenManager;
        this.salesRecordsRepository = salesRecordsRepository;
    }

    @Bean
    public LoginUser getLoginUserBean(){
        return   new LoginUser(verifyLoginUserRepository, algorithmEncryptPassword, jwtTokenManager);
    }

    @Bean
    public SalesRecords getSalesRecordsBean(){
        return   new SalesRecords(salesRecordsRepository);
    }
}
