package com.santosh.springaop.manager;

import org.springframework.stereotype.Component;

@Component
public class LoginManager {
    private String username;
    private String password;

    public void setParameters(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        if (username == null || username.trim().length() == 0) {
            throw new RuntimeException(("Username is null"));
        }

        if (password == null || password.trim().length() == 0) {
            return false;
        }

        return true;
    }

    public LoginResponse doLogin() {
        LoginResponse loginResponse = new LoginResponse();

        if (username.trim().equalsIgnoreCase("santosh") && password.trim().equalsIgnoreCase("pass")) {
            loginResponse.setSuccess(true);
            loginResponse.setMessage("Login successful");
            loginResponse.setId(1);
            loginResponse.setUsername(username);
            loginResponse.setName("Santosh Pun");
        } else {
            loginResponse.setSuccess(false);
            loginResponse.setMessage("Username or password is invalid");
        }
        return loginResponse;
    }
}
