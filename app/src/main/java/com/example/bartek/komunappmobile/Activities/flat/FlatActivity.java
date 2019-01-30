package com.example.bartek.komunappmobile.Activities.flat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class FlatActivity extends AppCompatActivity {
    private void startsActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat);

        Button addFlatButton = (Button)findViewById(R.id.btnLinkToNewFlat);
        addFlatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), AddFlat.class);
                startActivity(i);
            }
        });
    }





    String URL = "https://komunapp.herokuapp.com";
    String devApi = "/user/flat";
    Gson gson = new Gson();
    //
    public void tapJoin(View v) throws JSONException {
        EditText flatName = findViewById(R.id.editFlatName);
        EditText password = findViewById(R.id.editPasswordFlat);

        FlatBody flatBody = new FlatBody(flatName.getText().toString() ,  password.getText().toString());


        JsonObject json = new JsonParser().parse(gson.toJson(flatBody)).getAsJsonObject();

        JSONObject jo2 = new JSONObject(gson.toJson(flatBody));
        Log.e("Rest new" , jo2.toString());
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.PUT,
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
                        Toast.makeText(FlatActivity.this, "Invalid flatname or password", Toast.LENGTH_SHORT).show();
                    }
                }

        );

        requestQueue.add(objectRequest);
        //startsActivity();

    }

}
