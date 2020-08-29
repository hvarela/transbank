package com.prueba.transbank.domain.entities.error;

public enum ErrorType {

    UNEXPECTED_ERROR("FD00", "error  inesperado"),
    INVALID_NAME("FD01", "nombre no debe ser nulo o vacio"),
    INVALID_PASSWORD("FD02", "password no debe ser nulo o vacio");

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
