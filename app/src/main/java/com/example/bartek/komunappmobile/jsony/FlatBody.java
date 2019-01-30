package com.example.bartek.komunappmobile.jsony;

public class FlatBody {
    private String flatName;
    private String pass;

    public String getFlatName() {
        return flatName;
    }

    public void setFlatName(String flatName) {
        this.flatName = flatName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String passwordhash) {
        this.pass = pass;
    }

    public FlatBody(String flatName, String pass) {
        this.flatName = flatName;
        this.pass = pass;
    }
}