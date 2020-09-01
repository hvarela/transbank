package com.prueba.transbank.infrastructure.entrypoints.rest.request;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class LoginResponseTest {

    @Test
    public void validCreationLoginResponse() {
        LoginResponse loginResponse = new LoginResponse("3123");

        loginResponse.setToken("tito");

        assertEquals("tito",loginResponse.getToken());
    }


}