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
import java.util.ArrayList;

public class AddList extends AppCompatActivity {
    CustomAdapter customAdapter;
    TextView nameText ;
    ArrayList<String> products = new ArrayList<>();
    String listName;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
        nameText = findViewById(R.id.addListName);
        Intent i = getIntent();
        listName = i.getStringExtra("ListName");
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
        intent.putStringArrayListExtra("products" , products);
        intent.putExtra("name" , listName);
        setResult(RESULT_OK , intent);
        finish();
    }

    public void addShoppingItem(View view) {
        EditText text = findViewById(R.id.itemName);
        String name = text.getText().toString();
        products.add(name);
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.shop_item,null);
            TextView textView = view.findViewById(R.id.itemName);

            textView.setText(products.get(i));
            return view;
        }
    }
}
