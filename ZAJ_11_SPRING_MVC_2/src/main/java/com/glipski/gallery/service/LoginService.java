package com.glipski.gallery.service;

import org.springframework.core.env.Environment;

public class LoginService {
    private Environment env;
    boolean isLogged;

    public LoginService() {
        this.isLogged = false;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public boolean login(String username, String password) {
        if(username == env.getProperty("my.username") && password == env.getProperty("my.password"))
        {
            isLogged = true;
            return true;
        }
        else return false;
    }

    public void logout(){
        isLogged = false;
    }
}
