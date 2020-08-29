package com.prueba.transbank.domain.entities.error;

public enum ErrorType {

    UNEXPECTED_ERROR("FD00", "unexpected error"),
    INVALID_NAME("FD01", "name  is null or empty"),
    INVALID_PASSWORD("FD02", "password is null or empty");

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
