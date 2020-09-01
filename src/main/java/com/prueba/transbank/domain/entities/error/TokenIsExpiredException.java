package com.prueba.transbank.domain.entities.error;

public class TokenIsExpiredException extends  InternalErrorException {
    public TokenIsExpiredException() {
        super(ErrorType.TOKEN_EXPIRED_ERROR, ErrorType.TOKEN_EXPIRED_ERROR.getDescription() );
    }

    public TokenIsExpiredException(String msg) {
        super(ErrorType.TOKEN_EXPIRED_ERROR,  msg );
    }
}
