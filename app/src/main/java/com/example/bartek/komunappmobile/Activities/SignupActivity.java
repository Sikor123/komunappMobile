package com.example.bartek.komunappmobile.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bartek.komunappmobile.R;
import com.example.bartek.komunappmobile.data.UserData;
import com.example.bartek.komunappmobile.jsonObjectRequest.SignupObjectRequest;
import com.example.bartek.komunappmobile.jsony.LoginResponse;
import com.example.bartek.komunappmobile.jsony.SignUpBody;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {

    String URL = "https://komunapp.herokuapp.com";
    String devApi = "/users/sign-up";
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void signUp(View view) {
        try {
            signUp();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void signUp() throws JSONException {
        EditText editfirstname = findViewById(R.id.editFirstname);
        EditText editLastname = findViewById(R.id.editLastname);
        EditText editLogin = findViewById(R.id.editLogin);
        EditText editPassword = findViewById(R.id.editPassword);
        EditText editEmail = findViewById(R.id.editEmail);

        String firstname = editfirstname.getText().toString();
        String lastname = editLastname.getText().toString();
        String login =editLogin.getText().toString();
        String password = editPassword.getText().toString();
        String  email= editEmail.getText().toString();

        SignUpBody signUpBody = new SignUpBody(firstname,lastname,login,password,email);

        JSONObject jo2 = new JSONObject(gson.toJson(signUpBody));

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        SignupObjectRequest objectRequest = new SignupObjectRequest(
                Request.Method.POST,
                URL + devApi,
                jo2,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(SignupActivity.this, "very cool", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("RResponse" , error.toString());
                        Toast.makeText(SignupActivity.this, "User with provided data already exists", Toast.LENGTH_SHORT).show();
                    }
                }

        );

        requestQueue.add(objectRequest);
    }


}
