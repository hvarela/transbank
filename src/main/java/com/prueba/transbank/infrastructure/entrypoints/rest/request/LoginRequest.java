package com.prueba.transbank.infrastructure.entrypoints.rest.request;


public class LoginRequest {

    private String name;
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