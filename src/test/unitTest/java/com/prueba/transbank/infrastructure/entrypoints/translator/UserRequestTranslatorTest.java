package com.prueba.transbank.infrastructure.entrypoints.translator;

import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.fixture.UserRequestFixture;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.LoginRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRequestTranslatorTest {

    @Test
    public void ShouldTranslateUserRequest() {

        LoginRequest loginRequest = UserRequestFixture.create().withName("tito").withPassword("tito213").build();

        UserRequestTranslator userRequestTranslator = new UserRequestTranslator();

        User user = userRequestTranslator.translate(loginRequest);

        assertEquals(loginRequest.getName(), user.getName());
        assertEquals(loginRequest.getPassword(), loginRequest.getPassword());
    }
}