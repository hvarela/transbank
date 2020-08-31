package com.prueba.transbank.domain.entities.user;

import com.prueba.transbank.domain.entities.error.InvalidNameException;
import com.prueba.transbank.domain.entities.error.InvalidPasswordException;

import java.io.Serializable;

public class User{

    private String name;
    private String password;


    public User(String name, String password){
        this.name = name;
        this.password = password;
        validateName();
        validatePassword();
    }

    public String getPassword() {
        return password;
    }

    public String getName(){
        return name;
    }

    private void  validateName(){
        if(this.name == null || "".equals(this.name)) throw  new InvalidNameException();
    }

    private void validatePassword(){
        if(this.password == null || "".equals(this.password)) throw  new InvalidPasswordException();
    }


}
