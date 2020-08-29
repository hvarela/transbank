package com.prueba.transbank.infrastructure.repository;

import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.fixture.UserEntityFixture;
import com.prueba.transbank.fixture.UserFixture;
import com.prueba.transbank.infrastructure.entities.UserEntity;
import com.prueba.transbank.infrastructure.repository.RDBMS.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VerifyLoginUserRepositoryTest {

    private static final String NAME="tito";
    private static final String PASS="123456";
    private static final int ID=2;

    private VerifyLoginUserRepository verifyLoginUserRepository;
    private User user;
    private  UserEntity userEntity;

    @Mock
    UsersRepository usersRepository;

    @Before
    public void init(){
        verifyLoginUserRepository = new VerifyLoginUserRepository( usersRepository);
        userEntity = UserEntityFixture.create().
                withName(NAME).withPassword(PASS).
                withId(ID)
                .build();

        user = UserFixture.create()
            .withName(NAME)
            .withPassword(PASS)
            .build();

    }

    @Test
    public void verifyLoginSuccess(){

        when( usersRepository.findByNamePassword(any(String.class), any(String.class) ) ).thenReturn( Optional.of(userEntity));

        assertTrue( verifyLoginUserRepository.loginUser(user) );

    }


    @Test
    public void verifyLoginError(){

        when( usersRepository.findByNamePassword(any(String.class), any(String.class) ) ).thenReturn( Optional.empty());

        assertFalse( verifyLoginUserRepository.loginUser(user) );

    }


}