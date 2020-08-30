package com.prueba.transbank.domain.entities.error;

public class LoginErrorException extends  InternalErrorException {
    public LoginErrorException() {
        super(ErrorType.LOGGIN_ERROR, ErrorType.LOGGIN_ERROR.getDescription() );
    }
}
