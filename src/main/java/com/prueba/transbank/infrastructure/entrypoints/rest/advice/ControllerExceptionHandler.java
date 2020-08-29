package com.prueba.transbank.infrastructure.entrypoints.rest.advice;

import com.prueba.transbank.domain.entities.error.ApiError;
import com.prueba.transbank.domain.entities.error.InternalErrorException;
import com.prueba.transbank.domain.entities.error.InvalidNameException;
import com.prueba.transbank.domain.entities.error.InvalidPasswordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(InvalidNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleRequestLoginNameValidations(InvalidNameException e) {
        logger.error(e.getMessage());
        return new ApiError(HttpStatus.BAD_REQUEST.getReasonPhrase(), "handleRequestLoginNameValidations", e.getMessage());
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleRequestLoginPasswordValidations(InvalidPasswordException e) {
        logger.error(e.getMessage());
        return new ApiError(HttpStatus.BAD_REQUEST.getReasonPhrase(), "handleRequestLoginPasswordValidations", e.getMessage());
    }

    @ExceptionHandler(InternalErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleInternalErrorValidations(InternalErrorException e) {
        logger.error(e.getMessage());
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "handleInternalErrorValidations", e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleRuntimeValidations(RuntimeException e) {
        logger.error(e.getMessage());
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "handleRuntimeValidations", e.getMessage());
    }

}
