package com.prueba.transbank.domain.entities.user;

import com.prueba.transbank.domain.entities.error.InvalidNameException;
import com.prueba.transbank.domain.entities.error.InvalidPasswordException;
import org.springframework.util.StringUtils;

import java.io.Serializable;

public class User implements Serializable{

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

    public void setName(String name){
        this.name = name;

    }

    public void setPassword(String password) {
        this.password = password;

    }

    private void  validateName(){
        if(StringUtils.isEmpty(this.name)) throw  new InvalidNameException();
    }

    private void validatePassword(){
        if(StringUtils.isEmpty(this.password)) throw  new InvalidPasswordException();
    }


}
