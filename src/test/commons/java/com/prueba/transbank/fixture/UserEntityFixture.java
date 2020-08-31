package com.prueba.transbank.fixture;


import com.prueba.transbank.infrastructure.entitys.UserEntity;

public class UserEntityFixture extends AbstractFixture<UserEntity> {

    private static final  String  DEFAULT_NAME= "";
    private static final  String  DEFAULT_PASSWORD= "";
    private static final  int  DEFAULT_ID= 1;


    private int  id;
    private String name;
    private String password;

    private UserEntityFixture(int id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public static UserEntityFixture create(){
        return new UserEntityFixture(DEFAULT_ID, DEFAULT_NAME, DEFAULT_PASSWORD);
    }

    public UserEntityFixture withId(int id){
        this.id = id;
        return this;
    }

    public UserEntityFixture withName(String name){
        this.name = name;
        return this;
    }

    public UserEntityFixture withPassword(String password){
        this.password = password;
        return this;
    }

    public UserEntity build() {
        return new UserEntity(this.id, this.name, this.password);
    }
}
