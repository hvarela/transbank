package com.prueba.transbank.domain.entities.error;

public enum ErrorType {

    UNEXPECTED_ERROR("FD00", "Unexpected error"),
    INVALID_NAME("FD01", "Name  is null or empty"),
    INVALID_PASSWORD("FD02", "Password is null or empty"),
    LOGGIN_ERROR("FD03", "User not found in the DB"),
    INVALID_TOKEN_ERROR("FD04", "Token is invalid"),
    REQ_WITHOUT_TOKEN("FD05", "Request without Autorization Bearer token"),
    TOKEN_EXPIRED_ERROR("FD06", "Token Expired"),
    SALE_DATA_ERROR("FD07", "invalid sale data");

    private final String code;
    private final String description;

    ErrorType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
