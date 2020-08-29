package com.prueba.transbank.domain.entities.error;

public class InvalidNameException extends  InternalErrorException {
    public InvalidNameException(String message) {
        super(ErrorType.INVALID_NAME, message);
    }
}
