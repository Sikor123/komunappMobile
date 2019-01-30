package com.example.bartek.komunappmobile.jsony;

public class SignUpBody {
    private String firstname;
    private String lastname;
    private String login;
    private String passwordhash;
    private String email;

    public SignUpBody(String firstname, String lastname, String login, String passwordhash, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.passwordhash = passwordhash;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
