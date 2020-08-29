package com.prueba.transbank.infrastructure.entrypoints.rest;

import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.fixture.UserFixture;
import com.prueba.transbank.fixture.UserRequestFixture;
import com.prueba.transbank.infrastructure.entrypoints.rest.request.UserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    private static final String DEFAULT_NAME = "tito";
    private static final String DEFAULT_PASSWORD = "12345";

    @InjectMocks
    Controller controller;

    @Test
    public void testVerifyLoginSuccess() {

        UserRequest userRequest = UserRequestFixture.create()
                .withName(DEFAULT_NAME)
                .withPassword(DEFAULT_PASSWORD)
                .build();

        ResponseEntity<String> responseEntity = controller.loginUser( userRequest);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

  
}