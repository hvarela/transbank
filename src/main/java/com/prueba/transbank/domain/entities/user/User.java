package com.prueba.transbank.domain.entities.user;

import com.prueba.transbank.domain.entities.error.InvalidNameException;
import com.prueba.transbank.domain.entities.error.InvalidPasswordException;

public class User {

    private String name;
    private String password;

    public User(String name, String password){
        if(name.isEmpty()) throw  new InvalidNameException("el campo nombre es vacio");
        if(password.isEmpty()) throw  new InvalidPasswordException("el campo password es vacio");

        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName(){
        return name;
    }


}
