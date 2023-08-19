package com.CutyTeddyBear.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {

        boolean isValidUserName = username.equalsIgnoreCase("geolyun");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");

        return isValidPassword && isValidUserName;
    }
}
