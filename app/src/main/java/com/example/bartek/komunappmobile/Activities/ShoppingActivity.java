package com.example.bartek.komunappmobile.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bartek.komunappmobile.R;
import com.example.bartek.komunappmobile.dbObjects.ShoppingList;

import java.util.ArrayList;

public class ShoppingActivity extends AppCompatActivity {
    private ArrayList<ShoppingList> shoppingLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

    }
}
