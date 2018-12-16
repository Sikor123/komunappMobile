package com.example.bartek.komunappmobile.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
    }

    public void addShoppingList(View view) {
        Intent intent = new Intent(this,AddList.class);
        intent.putExtra("ListName", String.valueOf(listName.getText()));
        Log.e("przed" , String.valueOf(listName.getText()));
        intent.putExtra("shoppingLists" ,shoppingLists );
        startActivity(intent);
    }
}
