package com.prueba.transbank.domain.entities.error;

import java.util.Objects;
import java.util.StringJoiner;

public class ApiError {

    private String status;
    private String handler;
    private String error;

    public ApiError() {
    }

    public ApiError(String httpStatus, String handler, String error) {
        this.status = httpStatus;
        this.handler = handler;
        this.error =  error;
    }

    public String getStatus() {
        return status;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ApiError apiError = (ApiError) o;

        return  this.error == apiError.error &&
                this.handler == apiError.handler &&
                this.status == apiError.status;

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "ApiError" + "[", "]")
                .add("status=" + status)
                .add("handler='" + handler + "'")
                .add("errors=" + error)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getHandler(), getError());
    }
}
