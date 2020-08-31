package com.prueba.transbank.infrastructure.entrypoints.rest.translator;

import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.fixture.UserRequestFixture;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.LoginRequest;
import com.prueba.transbank.infrastructure.entrypoints.translator.UserRequestTranslator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class LoginRequestTranslatorTest {

    private static final String NAME="tito";
    private static final String PASS="1234iad";


    @Test
    public void verifyUserRequestTranslatorSuccess(){
        LoginRequest loginRequest = UserRequestFixture.create()
                .withPassword(PASS)
                .withName(NAME)
                .build();

        User user = UserRequestTranslator.translate(loginRequest);

        assertEquals(NAME, user.getName());
        assertEquals(PASS, user.getPassword());
    }
}
