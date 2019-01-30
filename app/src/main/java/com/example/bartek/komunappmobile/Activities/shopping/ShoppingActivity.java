package com.example.bartek.komunappmobile.Activities.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bartek.komunappmobile.R;
import com.example.bartek.komunappmobile.data.UserData;
import com.example.bartek.komunappmobile.dbObjects.ShoppingItem;
import com.example.bartek.komunappmobile.dbObjects.ShoppingList;

import java.util.ArrayList;

public class ShoppingActivity extends AppCompatActivity {
    private ArrayList<ShoppingList> shoppingLists = UserData.getShoppingLists();
    EditText listName ;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shopping);
        listName = findViewById(R.id.ListName);
        listView = (ListView) findViewById(R.id.lists) ;
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                openList(pos);
                Toast.makeText(ShoppingActivity.this,shoppingLists.get(pos).getDescription() , Toast.LENGTH_SHORT).show();
               // Log.e("wow" , shoppingLists.get(pos).getDescription());
            }
        });

    }

    private void openList(int pos){
        Intent i = new Intent(this , OpenList.class);
        i.putStringArrayListExtra("products" , shoppingLists.get(pos).getStringShopping()) ;
        i.putExtra("ListName" , shoppingLists.get(pos).getDescription());
        startActivity(i);
    }

    public void addShoppingList(View view) {
        Intent intent = new Intent(this, AddList.class);
        intent.putExtra("ListName", String.valueOf(listName.getText()));
        Log.e("pierwszy" , "jestem");
        startActivityForResult(intent, 999);
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
        public View getView(final int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.shopping_list_item,null);
            TextView textView = view.findViewById(R.id.shoppingListName);
            ImageView listDelete = view.findViewById(R.id.listDelete);
            textView.setText(shoppingLists.get(i).getDescription());

            listDelete.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    shoppingLists.remove(i);
                    notifyDataSetChanged();
                    //TODO POLACZYC Z API - WYSYLANIE REQUESTA DO USUNIECIA LISTY O ID i
                }
            });
            return view;
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("pierwszy" , String.valueOf(data.getStringArrayListExtra("products").size()));
        String n = data.getStringExtra("name");
        ArrayList<String> l = data.getStringArrayListExtra("products");
        ArrayList<ShoppingItem> shopping  = new ArrayList<ShoppingItem>();
        for (String item: l
             ) {
            shopping.add(new ShoppingItem(item , 0));
        }
        shoppingLists.add(new ShoppingList(n,shopping));
        listName.setText("");
        Log.e("pierwszy" , "koniec");
    }


}