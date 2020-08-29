package com.prueba.transbank.domain.entities.error;

public class InvalidPasswordException extends  InternalErrorException {
    public InvalidPasswordException(String message) {
        super(ErrorType.INVALID_PASSWORD, message);
    }
}
