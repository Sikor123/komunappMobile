package com.example.bartek.komunappmobile.Activities.flat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bartek.komunappmobile.Activities.MainActivity;
import com.example.bartek.komunappmobile.R;
import com.example.bartek.komunappmobile.data.UserData;
import com.example.bartek.komunappmobile.jsony.FlatBody;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddFlat extends AppCompatActivity {
    private void startsActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    String URL = "https://komunapp.herokuapp.com";
    String devApi = "/flat";
    Gson gson = new Gson();

    public void tapAdd(View v) throws JSONException {

        EditText flatName = findViewById(R.id.editFlatNameAdd);
        EditText password = findViewById(R.id.editPasswordFlatAdd);

        FlatBody flatBody = new FlatBody(flatName.getText().toString(), password.getText().toString());
        final JSONObject flatJSON = new JSONObject(gson.toJson(flatBody));

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, URL + devApi, flatJSON,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Integer flatId = response.getInt("id");
                            UserData.setFlatId(flatId);
                            Toast.makeText(AddFlat.this, "Created flat", Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            Toast.makeText(AddFlat.this, "There is no id in this json", Toast.LENGTH_SHORT).show();
                        }
                        startsActivity();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("RESPONSE ", error.toString());
                        Toast.makeText(AddFlat.this, "Invalid Flatname or password", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                //headers.put("Content-Type", "application/json");
                headers.put("Authorization", "Bearer " + UserData.getToken());
                return headers;
            }
        };

        requestQueue.add(objectRequest);
        //startsActivity();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flat);
    }
}
