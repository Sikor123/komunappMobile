package com.example.bartek.komunappmobile.jsony;

public class LoginBody {
    private String login;
    private String passwordhash;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public LoginBody(String login, String passwordhash) {
        this.login = login;
        this.passwordhash = passwordhash;
    }
}
