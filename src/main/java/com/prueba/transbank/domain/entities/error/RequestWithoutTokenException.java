package com.prueba.transbank.domain.entities.error;

public class RequestWithoutTokenException extends  InternalErrorException {
    public RequestWithoutTokenException() {
        super(ErrorType.REQ_WITHOUT_TOKEN, ErrorType.REQ_WITHOUT_TOKEN.getDescription() );
    }
}
