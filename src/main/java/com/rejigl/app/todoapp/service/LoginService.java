package com.rejigl.app.todoapp.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PSWD = "password";

    public boolean validateUser(String name, String pswd){

        if (name.equalsIgnoreCase(DEFAULT_USERNAME) && pswd.equalsIgnoreCase(DEFAULT_PSWD))
            return true;
        return false;

    }
}
