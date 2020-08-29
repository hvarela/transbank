package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.domain.usecase.port.VerifyLoginUserDataProvide;
import com.prueba.transbank.fixture.UserFixture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginUserTest {

    private static final String NAME= "tito";
    private static final String  PASS= "123";

    private LoginUser loginUser;

    @Mock
    VerifyLoginUserDataProvide verifyLoginUserDataProvide;

    @Before
    public void init(){
        loginUser = new LoginUser(verifyLoginUserDataProvide);
    }

    @Test
    public void  verifyLoginSuccess(){
        User user = UserFixture.create()
                .withName(NAME)
                .withPassword(PASS)
                .build();

        when( verifyLoginUserDataProvide.loginUser(any(User.class))).thenReturn(true);

        assertTrue(loginUser.login(user));
    }


    @Test
    public void  verifyLoginError(){
        User user = UserFixture.create()
                .withName(NAME)
                .withPassword(PASS)
                .build();

        when( verifyLoginUserDataProvide.loginUser(any(User.class))).thenReturn(false);

        assertFalse(loginUser.login(user));
    }

}