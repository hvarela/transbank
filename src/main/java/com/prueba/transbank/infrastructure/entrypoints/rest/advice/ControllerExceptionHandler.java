package com.prueba.transbank.infrastructure.entrypoints.rest.advice;

import com.prueba.transbank.domain.entities.error.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
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


    @ExceptionHandler(LoginErrorException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiError handleLoginErrorValidations(LoginErrorException e) {
        logger.error("usuario no encontrado en la BD");
        return new ApiError(HttpStatus.UNAUTHORIZED.getReasonPhrase(), "handleLoginErrorValidations", e.getMessage());
    }

    @ExceptionHandler(InvalidTokenException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiError handleInvalidTokenValidations(InvalidTokenException e) {
        logger.error("token invalido");
        return new ApiError(HttpStatus.UNAUTHORIZED.getReasonPhrase(), "handleInvalidTokenValidations", e.getMessage());
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
        logger.error("exception inesperada ",e);
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "handleRuntimeValidations", e.getMessage());
    }

    @ExceptionHandler(RequestWithoutTokenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleRQWithoutTokenValidations(RequestWithoutTokenException e) {
        logger.error("request sin Bearer token",e);
        return new ApiError(HttpStatus.BAD_REQUEST.getReasonPhrase(), "handleRQWithoutTokenValidations", e.getMessage());
    }

    @ExceptionHandler(TokenIsExpiredException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiError handleTokenIsExpiredValidations(TokenIsExpiredException e) {
        logger.error(e.getMessage());
        return new ApiError(HttpStatus.UNAUTHORIZED.getReasonPhrase(), "handleTokenIsExpiredValidations", e.getMessage());
    }

    @ExceptionHandler(SaleDataErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleSaleDataValidations(SaleDataErrorException e) {
        logger.error(e.getMessage());
        return new ApiError(HttpStatus.BAD_REQUEST.getReasonPhrase(), "handleSaleDataValidations", e.getMessage());
    }

}
