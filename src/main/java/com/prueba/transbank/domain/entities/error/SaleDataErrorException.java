package com.prueba.transbank.domain.entities.error;

public class SaleDataErrorException extends  InternalErrorException {
    public SaleDataErrorException(String msg) {
        super(ErrorType.SALE_DATA_ERROR, ErrorType.SALE_DATA_ERROR.getDescription().concat(msg));
    }
}
