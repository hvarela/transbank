package com.prueba.transbank.infrastructure.entrypoints.rest.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    @ApiModelProperty(value = "token de acceso", example = "epsakjdaodkqdkqkkcaokdpodqqp",  allowEmptyValue = false, required=true)
    private String token;


    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
