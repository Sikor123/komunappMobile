package com.example.bartek.komunappmobile.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bartek.komunappmobile.R;

public class AddList extends AppCompatActivity {

    TextView nameText ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
        nameText = findViewById(R.id.addListName);
        Intent i = getIntent();
        String listName;
        listName = i.getStringExtra("ListName");
        Log.e("name", listName);
        nameText.setText(listName);
    }

    public void accept(View view) {
        finish();
    }
}
