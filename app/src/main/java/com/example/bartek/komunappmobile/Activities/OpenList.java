package com.example.bartek.komunappmobile.Activities;

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

        Intent i = getIntent();
        listName = i.getStringExtra("ListName");
        products = i.getStringArrayListExtra("products");
        ListView listView =  findViewById(R.id.shoppingView) ;
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

//       ArrayAdapter<ArrayList> arrayAdapter = new ArrayAdapter<ArrayList>(this , android.R.layout.simple_list_item_1  , shoppingLists.get(shoppingLists.size()).getShopping() );
//       listView.setAdapter(arrayAdapter);
        Log.e("pierwszy" , "jestem2");


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
                products.remove(i);
                notifyDataSetChanged();
                //TODO POLACZYC Z API - WYSYLANIE REQUESTA DO USUNIECIA ITEMU O ID i
            }
        });

            textView.setText(products.get(i));
            return view;
        }
    }

}
