package com.prueba.transbank.fixture;


import com.prueba.transbank.domain.entities.user.User;

public class UserFixture extends AbstractFixture<User> {

    private static final  String  DEFAULT_NAME= "";
    private static final  String  DEFAULT_PASSWORD= "";

    private String name;
    private String password;

    public UserFixture(String name, String password){
        this.name = name;
        this.password = password;
    }

    public static UserFixture create(){
        return new UserFixture(DEFAULT_NAME, DEFAULT_PASSWORD);
    }

    public UserFixture withName(String name){
        this.name = name;
        return this;
    }

    public UserFixture withPassword(String password){
        this.password = password;
        return this;
    }

    public User build() {
        return new User(this.name, this.password);
    }
}
