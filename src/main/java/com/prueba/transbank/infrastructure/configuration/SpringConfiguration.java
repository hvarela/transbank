package com.prueba.transbank.infrastructure.configuration;

import com.prueba.transbank.domain.usecase.GetProductsSolds;
import com.prueba.transbank.domain.usecase.LoginUser;
import com.prueba.transbank.domain.usecase.SalesRecords;
import com.prueba.transbank.infrastructure.repository.GetProductsSoldsRepository;
import com.prueba.transbank.infrastructure.repository.SalesRecordsRepository;
import com.prueba.transbank.infrastructure.repository.VerifyLoginUserRepository;
import com.prueba.transbank.infrastructure.security.AlgorithmEncryptPassword;
import com.prueba.transbank.infrastructure.security.JwtTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {



    private SalesRecordsRepository salesRecordsRepository;
    private GetProductsSoldsRepository getProductsSoldsRepository;

    @Autowired
    SpringConfiguration(SalesRecordsRepository salesRecordsRepository,
                        GetProductsSoldsRepository getProductsSoldsRepository
                         ){
        this.salesRecordsRepository = salesRecordsRepository;
        this.getProductsSoldsRepository = getProductsSoldsRepository;
    }

    @Bean
    public SalesRecords getSalesRecordsBean(){
        return   new SalesRecords(salesRecordsRepository);
    }


    @Bean
    public GetProductsSolds getProducsSoldsBean(){
        return new GetProductsSolds(getProductsSoldsRepository);
    }
}
