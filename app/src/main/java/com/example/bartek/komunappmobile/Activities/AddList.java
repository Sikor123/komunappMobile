package com.example.bartek.komunappmobile.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.bartek.komunappmobile.R;

public class AddList extends AppCompatActivity {

    EditText editText ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
        editText = findViewById(R.id.addListName);
        Intent i = getIntent();
        String listName;
        listName = i.getStringExtra("ListName");
        Log.e("name", listName);
        editText.setText(listName);
    }
}
