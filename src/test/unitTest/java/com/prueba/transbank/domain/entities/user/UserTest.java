package com.prueba.transbank.domain.entities.user;

import com.prueba.transbank.domain.entities.error.InvalidNameException;
import com.prueba.transbank.domain.entities.error.InvalidPasswordException;
import com.prueba.transbank.fixture.UserFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UserTest {

    private static  final String  DEFAULT_NAME="tito";
    private static  final String  DEFAULT_PASSWORD="2134";

    @Test(expected = InvalidNameException.class)
    public void  createUserWithInvalidName(){
        User user= UserFixture.create().withPassword(DEFAULT_PASSWORD).build();
    }

    @Test(expected = InvalidPasswordException.class)
    public void  createUserWithInvalidPassword(){
        User user= UserFixture.create().withName(DEFAULT_NAME).build();
    }

    @Test
    public void createValidUser(){
        User user = UserFixture.create()
                .withName(DEFAULT_NAME)
                .withPassword(DEFAULT_PASSWORD)
                .build();

        assertEquals(DEFAULT_NAME, user.getName());
        assertEquals(DEFAULT_PASSWORD, user.getPassword());

    }


}