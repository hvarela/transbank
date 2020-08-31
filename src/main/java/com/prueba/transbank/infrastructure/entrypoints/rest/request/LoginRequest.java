package com.prueba.transbank.infrastructure.entrypoints.rest.request;


import io.swagger.annotations.ApiModelProperty;

public class LoginRequest {

    @ApiModelProperty(value = "nombre del usuario", example = "jose",  allowEmptyValue = false, required=true)
    private String name;
    @ApiModelProperty(value = "password del usuario", example = "jose123",allowEmptyValue = false, required=true)
    private String password;

    public LoginRequest(){}

    public LoginRequest(String name, String password){
        this.name = name;
        this.password = password;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}
