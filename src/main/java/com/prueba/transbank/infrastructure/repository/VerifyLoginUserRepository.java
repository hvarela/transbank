package com.prueba.transbank.infrastructure.repository;

import com.prueba.transbank.domain.usecase.port.VerifyLoginUserDataProvide;
import com.prueba.transbank.infrastructure.entitys.UserEntity;
import com.prueba.transbank.infrastructure.repository.RDBMS.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class VerifyLoginUserRepository implements VerifyLoginUserDataProvide {

    private Logger logger = LoggerFactory.getLogger(VerifyLoginUserRepository.class);


    private final UsersRepository usersRepository;

    VerifyLoginUserRepository( UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean loginUser(String name, String encrytedPass) {
        logger.debug( String.format("Buscando en BD  usuario   name [%s]  password [%.10s...]", name, encrytedPass));
        Optional<UserEntity> userEntity = usersRepository.findByNamePassword(name, encrytedPass);

        return userEntity.isPresent();
    }


}
