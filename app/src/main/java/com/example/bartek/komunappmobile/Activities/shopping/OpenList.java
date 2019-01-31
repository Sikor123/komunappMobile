package com.example.bartek.komunappmobile.Activities.shopping;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.bartek.komunappmobile.R;
import com.example.bartek.komunappmobile.data.UserData;
import com.example.bartek.komunappmobile.dbObjects.ShoppingItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OpenList extends AppCompatActivity {

    TextView nameText;
    String listName;
    Integer listId;
    ArrayList<ShoppingItem> products = new ArrayList<>();;
    String URL = "https://komunapp.herokuapp.com";
    String devApi = "/items/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_list);

        Intent i = getIntent();
        listName = i.getStringExtra("ListName");
        listId = i.getIntExtra("listId", 0);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest objectRequest = new JsonArrayRequest(Request.Method.GET, URL + devApi + listId, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for(int i = 0; i < response.length(); i++){
                                JSONObject jresponse = response.getJSONObject(i);
                                products.add(new ShoppingItem(jresponse.getInt("shoppingitemid"),jresponse.getString("description"),jresponse.getDouble("price")));
                            }
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("RESPONSE ", error.toString());
                        Toast.makeText(OpenList.this, "Invalid Flatname or password", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", "Bearer " + UserData.getToken());
                return headers;
            }
        };

        requestQueue.add(objectRequest);
        //startsActivity();

        ListView listView =  findViewById(R.id.shoppingView) ;
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        nameText = findViewById(R.id.viewListName);
        Log.e("name", listName);
        nameText.setText(listName);
    }

    public void done(View view) {
        finish();
    }


    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return products.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.shop_item,null);
            TextView textView = view.findViewById(R.id.itemName);

            ImageView itemDelete = view.findViewById(R.id.itemDelete);

            final RelativeLayout layout = view.findViewById(R.id.layout);

            itemDelete.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    RequestQueue requestQueue = Volley.newRequestQueue(layout.getContext());
                    JsonArrayRequest objectRequest = new JsonArrayRequest(Request.Method.DELETE, URL + "/items/" + products.get(i).getItemId(), null,
                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.e("RESPONSE ", error.toString());

                                }
                            }
                    ){
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> headers = new HashMap<String, String>();
                            headers.put("Content-Type", "application/json");
                            headers.put("Authorization", "Bearer " + UserData.getToken());
                            return headers;
                        }
                    };

                    requestQueue.add(objectRequest);
                    //startsActivity();
                    products.remove(i);
                notifyDataSetChanged();

            }
        });
            textView.setText(products.get(i).getDescription());
            return view;
        }
    }

}
