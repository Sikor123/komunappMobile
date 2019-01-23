package com.example.bartek.komunappmobile.Activities;

import android.content.Intent;
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
import android.widget.ListView;
import android.widget.TextView;

import com.example.bartek.komunappmobile.R;

import java.util.ArrayList;

public class OpenList extends AppCompatActivity {

    TextView nameText;
    String listName;
    ArrayList<String> products = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_list);
        setContentView(R.layout.activity_add_list);
        nameText = findViewById(R.id.viewListName);
        Intent i = getIntent();

        listName = i.getStringExtra("ListName");
        products = i.getStringArrayListExtra("products");
//        shoppingLists = ( ArrayList<ShoppingList>)  i.getSerializableExtra("shoppingLists");


        ListView listView =  findViewById(R.id.shopping) ;


        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

//       ArrayAdapter<ArrayList> arrayAdapter = new ArrayAdapter<ArrayList>(this , android.R.layout.simple_list_item_1  , shoppingLists.get(shoppingLists.size()).getShopping() );
//       listView.setAdapter(arrayAdapter);
        Log.e("pierwszy" , "jestem2");



        Log.e("name", listName);
        nameText.setText(listName);
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.shop_item,null);
            TextView textView = view.findViewById(R.id.itemName);

            textView.setText(products.get(i));
            return view;
        }
    }

}
