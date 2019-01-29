package com.example.bartek.komunappmobile.jsony;

public class FlatBody {
    private String flatName;
    private String passwordhash;

    public String getFlatName() {
        return flatName;
    }

    public void setFlatName(String flatName) {
        this.flatName = flatName;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public FlatBody(String flatName, String passwordhash) {
        this.flatName = flatName;
        this.passwordhash = passwordhash;
    }
}