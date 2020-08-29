package com.prueba.transbank.domain.entities.user;

import com.prueba.transbank.domain.entities.error.InvalidNameException;
import com.prueba.transbank.domain.entities.error.InvalidPasswordException;

import java.io.Serializable;

public class User implements Serializable{

    private String name;
    private String password;

    public User(){}

    public User(String name, String password){
        validateName(name);
        validatePassword(password);

        this.name = name;
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setPassword(String password) {
        validatePassword(password);
        this.password = password;
    }

    private void  validateName(String name){
        if(name.isEmpty()) throw  new InvalidNameException("el campo nombre es vacio");
    }

    private void validatePassword(String password){
        if(password.isEmpty()) throw  new InvalidPasswordException("el campo password es vacio");
    }


}
