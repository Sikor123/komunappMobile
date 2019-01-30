package com.example.bartek.komunappmobile.Activities.flat;

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
import com.example.bartek.komunappmobile.Activities.MainActivity;
import com.example.bartek.komunappmobile.R;
import com.example.bartek.komunappmobile.jsony.FlatBody;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

public class AddFlat extends AppCompatActivity {
    private void startsActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    String URL = "https://komunapp.herokuapp.com";
    String devApi = "/flat";
    Gson gson = new Gson();
    //
    public void tapAdd(View v) throws JSONException {
        EditText flatName = findViewById(R.id.editFlatNameAdd);
        EditText password = findViewById(R.id.editPasswordFlatAdd);
        Log.e("RestResponse" , URL + devApi+"\n");
        FlatBody flatBody = new FlatBody(flatName.getText().toString() ,  password.getText().toString());
        Log.e("RestResponse" , gson.toJson(flatBody));

        JsonObject json = new JsonParser().parse(gson.toJson(flatBody)).getAsJsonObject();

        JSONObject jo2 = new JSONObject(gson.toJson(flatBody));
        Log.e("Rest new" , jo2.toString());
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.POST,
                URL + devApi,
                jo2,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("RResponse" , response.toString());
                        startsActivity();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response" , error.toString());
                        Toast.makeText(AddFlat.this, "Invalid flatname or password", Toast.LENGTH_SHORT).show();
                    }
                }

        );

        requestQueue.add(objectRequest);
        //startsActivity();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flat);
    }
}
