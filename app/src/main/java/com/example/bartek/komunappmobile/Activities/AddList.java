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

    TextView nameText ;
    ArrayList<ShoppingList> shoppingLists;
    ShoppingList sList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
        nameText = findViewById(R.id.addListName);
        Intent i = getIntent();
        String listName;
        listName = i.getStringExtra("ListName");
        shoppingLists = ( ArrayList<ShoppingList>)  i.getSerializableExtra("shoppingLists");
        shoppingLists.add(new ShoppingList(listName));
        sList =  shoppingLists.get(shoppingLists.size()-1);

        ListView listView = (ListView) findViewById(R.id.shopping) ;
        sList.getShopping().add(new ShoppingItem("" , 10));
        sList.getShopping().add(new ShoppingItem("" , 10));
        sList.getShopping().add(new ShoppingItem("" , 10));

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

//        ArrayAdapter<ShoppingItem> arrayAdapter = new ArrayAdapter<ShoppingItem>(this , android.R.layout.simple_list_item_1  , shoppingLists.get(shoppingLists.size()).getShopping() );
//        listView.setAdapter(arrayAdapter);




        Log.e("name", listName);
        nameText.setText(listName);
    }

    public void accept(View view) {
        finish();
    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return sList.getShopping().size();
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

            editText.setText(sList.getShopping().get(i).getDescription());
            return view;
        }
    }
}
