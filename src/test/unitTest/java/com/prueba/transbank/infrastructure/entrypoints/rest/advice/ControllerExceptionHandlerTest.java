package com.prueba.transbank.infrastructure.entrypoints.rest.advice;

import com.prueba.transbank.domain.entities.error.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ControllerExceptionHandlerTest {

    private static final  String MSG_ERROR = "error runtime";

    private ControllerExceptionHandler controllerExceptionHandler;

    @Before
    public void init(){
        controllerExceptionHandler = new ControllerExceptionHandler();
    }

    private  String getMethodName() {

        // Verficamos que exista
        if (Thread.currentThread().getStackTrace().length>2) {
            return Thread.currentThread().getStackTrace()[2].getMethodName();
        } else {
            return "undefined";
        }
    }

    @Test
    public void handleRequestLoginNameValidations() {

        ApiError apiError = controllerExceptionHandler.handleRequestLoginNameValidations(new InvalidNameException());

        assertEquals(ErrorType.INVALID_NAME.getDescription(), apiError.getError());
        assertEquals(HttpStatus.BAD_REQUEST.getReasonPhrase(), apiError.getStatus());
        assertEquals(getMethodName(), apiError.getMessage());
    }

    @Test
    public void handleRequestLoginPasswordValidations() {
        ApiError apiError = controllerExceptionHandler.handleRequestLoginPasswordValidations(new InvalidPasswordException());

        assertEquals(ErrorType.INVALID_PASSWORD.getDescription(), apiError.getError());
        assertEquals(HttpStatus.BAD_REQUEST.getReasonPhrase(), apiError.getStatus());
        assertEquals(getMethodName(), apiError.getMessage());
    }

    @Test
    public void handleInternalErrorValidations() {
        ApiError apiError = controllerExceptionHandler.handleInternalErrorValidations(new InternalErrorException());

        assertEquals(ErrorType.UNEXPECTED_ERROR.getDescription(), apiError.getError());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), apiError.getStatus());
        assertEquals(getMethodName(), apiError.getMessage());
    }

    @Test
    public void handleRuntimeValidations() {
        ApiError apiError = controllerExceptionHandler.handleRuntimeValidations(new RuntimeException(MSG_ERROR));

        assertEquals(MSG_ERROR, apiError.getError());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), apiError.getStatus());
        assertEquals(getMethodName(), apiError.getMessage());
    }
}