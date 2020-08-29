package com.prueba.transbank.infrastructure.entrypoints.rest.request;


public class UserRequest  {


    private String name;
    private String password;

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
