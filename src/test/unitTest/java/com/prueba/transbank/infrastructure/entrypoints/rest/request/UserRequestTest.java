package com.prueba.transbank.infrastructure.entrypoints.rest.request;

import com.prueba.transbank.fixture.UserRequestFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UserRequestTest {

    private static final String NAME = "tito";
    private static final String PASS = "12345";

    @Test
    public void testVerifyCreateUserRequestConstructor() {
        UserRequest userRequest  = UserRequestFixture.create()
                .withName(NAME)
                .withPassword(PASS)
                .build();

        assertEquals(NAME, userRequest.getName());
        assertEquals(PASS, userRequest.getPassword());
    }

    @Test
    public void testVerifyCreateUserRequestSetter() {
        UserRequest userRequest  = UserRequestFixture.create().build();

        userRequest.setName(NAME);
        userRequest.setPassword(PASS);

        assertEquals(NAME, userRequest.getName());
        assertEquals(PASS, userRequest.getPassword());
    }
}