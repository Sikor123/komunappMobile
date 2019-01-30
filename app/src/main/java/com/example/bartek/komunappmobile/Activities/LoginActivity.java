package com.example.bartek.komunappmobile.Activities;


import android.content.Intent;
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
import com.example.bartek.komunappmobile.jsony.LoginBody;
import com.example.bartek.komunappmobile.jsony.LoginResponse;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private void startsActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    String URL = "https://komunapp.herokuapp.com";
    String devApi = "/login";
        Gson gson = new Gson();
    //
    public void tapLogin(View v) throws JSONException {
        EditText login = findViewById(R.id.editLogin);
        EditText password = findViewById(R.id.editPassword);

        LoginBody loginBody = new LoginBody(login.getText().toString() ,  password.getText().toString());

        JSONObject jo2 = new JSONObject(gson.toJson(loginBody));

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.POST,
                URL + devApi,
                jo2,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        LoginResponse obj = gson.fromJson(response.toString(), LoginResponse.class);
                        Log.e("wow" , obj.getToken());
                        UserData.setToken(obj.getToken());
                        startsActivity();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("RResponse" , error.toString());
                        Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }

        );

        requestQueue.add(objectRequest);
        //startsActivity();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.e("Rest Response" , "I'm in");



    }
}


