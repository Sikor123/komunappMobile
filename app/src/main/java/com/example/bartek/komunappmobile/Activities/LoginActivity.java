package com.example.bartek.komunappmobile.Activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bartek.komunappmobile.R;
import com.example.bartek.komunappmobile.jsony.LoginBody;
import com.google.gson.Gson;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    String URL = "http://192.168.0.2";
    String port = "8080";
    String devApi = "/user/sign-up";
    Gson gson = new Gson();
    public void tapLogin(View v) {
        EditText login = findViewById(R.id.editLogin);
        EditText password = findViewById(R.id.editPassword);
        Log.e("RestResponse" , URL +":" + port + devApi+"\n");
        LoginBody loginBody = new LoginBody(login.getText().toString() ,  password.getText().toString());
        Log.e("RestResponse" , gson.toJson(loginBody));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos/1",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("RestResponse" , response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response" , error.toString());
                    }
                }

        );

        requestQueue.add(objectRequest);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.e("Rest Response" , "I'm in");



    }
}
