package com.prueba.transbank.domain.entities.error;

public class InvalidNameException extends  InternalErrorException {

    public InvalidNameException(){
        super(ErrorType.INVALID_NAME, ErrorType.INVALID_NAME.getDescription());
    }

}
