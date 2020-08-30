package com.prueba.transbank.domain.usecase;

import com.prueba.transbank.domain.entities.error.LoginErrorException;
import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.domain.usecase.port.VerifyLoginUserDataProvide;
import com.prueba.transbank.fixture.UserFixture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginUserTest {

    private static final String NAME= "tito";
    private static final String  PASS= "123";

    private LoginUser loginUser;
    private User user;

    @Mock
    VerifyLoginUserDataProvide verifyLoginUserDataProvide;

    @Before
    public void init(){
        loginUser = new LoginUser(verifyLoginUserDataProvide);
        user =  UserFixture.create()
                .withName(NAME)
                .withPassword(PASS)
                .build();
    }

    @Test
    public void  verifyLoginSuccess(){

        when( verifyLoginUserDataProvide.loginUser(any(String.class),any(String.class))).thenReturn(true);

        assertTrue(loginUser.login(user));
    }


    @Test(expected = LoginErrorException.class)
    public void  verifyLoginError(){

        when( verifyLoginUserDataProvide.loginUser(any(String.class),any(String.class))).thenReturn(false);

        loginUser.login(user);
    }

}