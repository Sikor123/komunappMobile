package com.example.bartek.komunappmobile.android;

import android.app.Application;

public class MyApplication extends Application {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
