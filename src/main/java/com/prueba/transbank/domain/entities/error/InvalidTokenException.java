package com.prueba.transbank.domain.entities.error;

public class InvalidTokenException extends  InternalErrorException {
    public InvalidTokenException() {
        super(ErrorType.INVALID_TOKEN_ERROR, ErrorType.INVALID_TOKEN_ERROR.getDescription() );
    }
}
