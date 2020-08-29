package com.prueba.transbank.domain.entities.error;

public class InternalErrorException extends RuntimeException {

    private final ErrorType errorType;

    public InternalErrorException() {
        this(ErrorType.UNEXPECTED_ERROR, ErrorType.UNEXPECTED_ERROR.getDescription() );
    }

    public InternalErrorException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

}
