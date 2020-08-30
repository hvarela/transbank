package com.prueba.transbank.fixture;


import com.prueba.transbank.infrastructure.entrypoints.rest.request.LoginRequest;

public class UserRequestFixture extends AbstractFixture<LoginRequest> {

    private static final  String  DEFAULT_NAME= "";
    private static final  String  DEFAULT_PASSWORD= "";

    private String name;
    private String password;

    public UserRequestFixture(String name, String password){
        this.name = name;
        this.password = password;
    }

    public static UserRequestFixture create(){
        return new UserRequestFixture(DEFAULT_NAME, DEFAULT_PASSWORD);
    }

    public UserRequestFixture withName(String name){
        this.name = name;
        return this;
    }

    public UserRequestFixture withPassword(String password){
        this.password = password;
        return this;
    }

    public LoginRequest build() {
        return new LoginRequest(this.name, this.password);
    }
}
