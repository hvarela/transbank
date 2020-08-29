package com.prueba.transbank.domain.entities.error;

public class InvalidPasswordException extends  InternalErrorException {
    public InvalidPasswordException() {
        super(ErrorType.INVALID_PASSWORD, ErrorType.INVALID_PASSWORD.getDescription() );
    }
}
