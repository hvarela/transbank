package com.prueba.transbank.infrastructure.entrypoints.rest;

import com.prueba.transbank.domain.entities.user.User;
import com.prueba.transbank.fixture.UserFixture;
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
    public void testLoginOk() {

        User user = UserFixture.create()
                .withName(DEFAULT_NAME)
                .withPassword(DEFAULT_PASSWORD)
                .build();

        ResponseEntity<String> responseEntity = controller.loginUser( user);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

  
}