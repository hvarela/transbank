package com.prueba.transbank.domain.entities.error;

public class TokenIsExpiredException extends  InternalErrorException {
    public TokenIsExpiredException() {
        super(ErrorType.REQ_WITHOUT_TOKEN, ErrorType.REQ_WITHOUT_TOKEN.getDescription() );
    }

    public TokenIsExpiredException(String msg) {
        super(ErrorType.REQ_WITHOUT_TOKEN,  msg );
    }
}
