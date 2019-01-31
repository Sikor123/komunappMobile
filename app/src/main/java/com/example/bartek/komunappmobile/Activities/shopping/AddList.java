package com.example.bartek.komunappmobile.Activities.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bartek.komunappmobile.R;
import com.example.bartek.komunappmobile.data.UserData;
import com.example.bartek.komunappmobile.dbObjects.ShoppingItem;
import com.example.bartek.komunappmobile.dbObjects.ShoppingList;
import com.example.bartek.komunappmobile.jsony.FlatBody;
import com.example.bartek.komunappmobile.jsony.ShoppingItemBody;
import com.example.bartek.komunappmobile.jsony.ShoppingListBody;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddList extends AppCompatActivity {
    CustomAdapter customAdapter;
    TextView nameText ;
    ArrayList<ShoppingItem> products = new ArrayList<>();
    String listName;
    ListView listView;

    String URL = "https://komunapp.herokuapp.com";
    String devApi = "/shoppingList";
    Gson gson = new Gson();
    Integer listId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
        nameText = findViewById(R.id.addListName);
        Intent i = getIntent();
        listName = i.getStringExtra("ListName");



        ShoppingListBody shoppingListBody = new ShoppingListBody(listName);
        JSONObject listJSON= null;
        try {
            listJSON = new JSONObject(gson.toJson(shoppingListBody));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new  JsonObjectRequest(Request.Method.POST, URL + devApi, listJSON,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            listId = response.getInt("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("RESPONSE ", error.toString());
                        Toast.makeText(AddList.this, "Invalid Flatname or password", Toast.LENGTH_SHORT).show();
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





        listView =  findViewById(R.id.shopping) ;
        customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        nameText.setText(listName);
    }

    public void accept(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Log.e("pierwszy" , "jestem3");
        Log.e("pierwszy" , String.valueOf(products.size()));
        Intent intent = new Intent();
        intent.putExtra("name" , listName);
        setResult(RESULT_OK , intent);
        finish();
    }

    public void addShoppingItem(View view) {
        EditText text = findViewById(R.id.itemName);
        String name = text.getText().toString();

        final ShoppingItemBody shoppingItemBody = new ShoppingItemBody(listId, name, 69.69);

        JSONObject shoppingJson = null;
        try {
            shoppingJson = new JSONObject(gson.toJson(shoppingItemBody)) ;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new  JsonObjectRequest(Request.Method.POST, URL + "/items", shoppingJson,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            products.add(new ShoppingItem(response.getInt("id"),shoppingItemBody.getDescription(), shoppingItemBody.getPrice()));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("RESPONSE ", error.toString());
                        Toast.makeText(AddList.this, "Invalid Flatname or password", Toast.LENGTH_SHORT).show();
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




        text.setText("");
        listView.setAdapter(customAdapter);
    }



    class CustomAdapter extends BaseAdapter{

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
            textView.setText(products.get(i).getDescription());

            final ImageView itemDelete = view.findViewById(R.id.itemDelete);

            itemDelete.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    itemDelete.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            RequestQueue requestQueue = Volley.newRequestQueue(itemDelete.getContext());
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
                            notifyDataSetChanged();

                        }
                    });
                    products.remove(i);
                    notifyDataSetChanged();
                    //TODO POLACZYC Z API - WYSYLANIE REQUESTA DO USUNIECIA ITEMU O ID i
                }
            });

            return view;
        }
    }
}
