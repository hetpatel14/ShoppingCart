package com.shop.model;


import javax.persistence.Entity;
import javax.persistence.Table;


public class LoginModel {


    private String name,password;

    public LoginModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    LoginModel(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
