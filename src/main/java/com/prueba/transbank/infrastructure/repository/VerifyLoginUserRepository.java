package com.prueba.transbank.infrastructure.repository;

import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.domain.usecase.port.VerifyLoginUserDataProvide;
import com.prueba.transbank.infrastructure.repository.RDBMS.UsersRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VerifyLoginUserRepository implements VerifyLoginUserDataProvide {

    private final UsersRepository usersRepository;

    VerifyLoginUserRepository( UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean loginUser(User user) {

        

        return false;
    }




}
