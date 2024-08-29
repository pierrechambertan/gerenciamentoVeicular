package com.omnilink.veiculosclientesapi.domain.user;

public class AuthenticationDTO {

    private String login;
    private String password;

    // Getters e Setters

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
