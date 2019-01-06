package com.example.bartek.komunappmobile.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bartek.komunappmobile.R;
import com.example.bartek.komunappmobile.dbObjects.ShoppingList;

import java.util.ArrayList;

public class ShoppingActivity extends AppCompatActivity {
    private ArrayList<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();
    EditText listName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        listName = findViewById(R.id.ListName);
        ListView listView = (ListView) findViewById(R.id.lists) ;
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    public void addShoppingList(View view) {
        Intent intent = new Intent(this,AddList.class);
        intent.putExtra("ListName", String.valueOf(listName.getText()));
        Log.e("przed" , String.valueOf(listName.getText()));
        intent.putExtra("shoppingLists" ,shoppingLists );
        startActivity(intent);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return shoppingLists.size();
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
            view = getLayoutInflater().inflate(R.layout.shopping_list_item,null);
            TextView textView = view.findViewById(R.id.shoppingListName);

            textView.setText(shoppingLists.get(i).getDescription());
            return view;
        }
    }
}
