package com.prueba.transbank.infrastructure.entrypoints.rest.request;

import com.prueba.transbank.fixture.UserRequestFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class LoginRequestTest {

    private static final String NAME = "tito";
    private static final String PASS = "12345";

    @Test
    public void testVerifyCreateUserRequestConstructor() {
        LoginRequest loginRequest = UserRequestFixture.create()
                .withName(NAME)
                .withPassword(PASS)
                .build();

        assertEquals(NAME, loginRequest.getName());
        assertEquals(PASS, loginRequest.getPassword());
    }

    @Test
    public void testVerifyCreateUserRequestSetter() {
        LoginRequest loginRequest = UserRequestFixture.create().build();

        loginRequest.setName(NAME);
        loginRequest.setPassword(PASS);

        assertEquals(NAME, loginRequest.getName());
        assertEquals(PASS, loginRequest.getPassword());
    }
}