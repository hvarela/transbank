package com.prueba.transbank.domain.entities.user;

import com.prueba.transbank.domain.entities.error.InvalidNameException;
import com.prueba.transbank.domain.entities.error.InvalidPasswordException;

import java.io.Serializable;

public class User implements Serializable{

    private String name;
    private String password;

    public User(){}

    public User(String name, String password){
        this.name = name;
        this.password = password;
        validate();
    }

    public String getPassword() {
        return password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
        validateName();
    }

    public void setPassword(String password) {
        this.password = password;
        validatePassword();
    }

    public  void validate(){
        validateName();
        validatePassword();
    }

    private void  validateName(){
        if(this.name == null ||  this.name.isEmpty()) throw  new InvalidNameException();
    }

    private void validatePassword(){
        if(this.password == null || this.password.isEmpty()) throw  new InvalidPasswordException();
    }


}
