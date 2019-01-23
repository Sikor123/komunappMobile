package com.example.bartek.komunappmobile.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bartek.komunappmobile.R;
import com.example.bartek.komunappmobile.dbObjects.ShoppingItem;
import com.example.bartek.komunappmobile.dbObjects.ShoppingList;

import java.util.ArrayList;

public class AddList extends AppCompatActivity {
    CustomAdapter customAdapter;
    TextView nameText ;
    ArrayList<String> products = new ArrayList<>();
    String listName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
        nameText = findViewById(R.id.addListName);
        Intent i = getIntent();

        listName = i.getStringExtra("ListName");
//        shoppingLists = ( ArrayList<ShoppingList>)  i.getSerializableExtra("shoppingLists");


        ListView listView =  findViewById(R.id.shopping) ;
        products.add("");
        products.add("");
        products.add("");

        customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

//       ArrayAdapter<ArrayList> arrayAdapter = new ArrayAdapter<ArrayList>(this , android.R.layout.simple_list_item_1  , shoppingLists.get(shoppingLists.size()).getShopping() );
//       listView.setAdapter(arrayAdapter);
        Log.e("pierwszy" , "jestem2");



        Log.e("name", listName);
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
        intent.putStringArrayListExtra("products" , products);
        intent.putExtra("name" , listName);
        setResult(RESULT_OK , intent);
        finish();
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.shop_item,null);
            EditText editText = view.findViewById(R.id.itemName);

            editText.setText(products.get(i));
            return view;
        }
    }
}
