package com.example.bartek.komunappmobile.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.bartek.komunappmobile.Activities.discussion.DiscussionActivity;
import com.example.bartek.komunappmobile.Activities.flat.FlatActivity;
import com.example.bartek.komunappmobile.Activities.payment.PaymentActivity;
import com.example.bartek.komunappmobile.Activities.shopping.ShoppingActivity;
import com.example.bartek.komunappmobile.Activities.task.TaskActivity;
import com.example.bartek.komunappmobile.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button firstActivityBtn = (Button)findViewById(R.id.btnOne);
        firstActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), ShoppingActivity.class);
                startActivity(i);
            }
        });

        Button secondActivityBtn = (Button)findViewById(R.id.btnTwo);
        secondActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), DiscussionActivity.class);
                startActivity(i);
            }
        });

        Button thirdActivityBtn = (Button)findViewById(R.id.btnThree);
        thirdActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), FlatActivity.class);
                startActivity(i);
            }
        });

        Button fourthActivityBtn = (Button)findViewById(R.id.btnFour);
        fourthActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), PaymentActivity.class);
                startActivity(i);
            }
        });

        Button fifthActivityBtn = (Button)findViewById(R.id.btnFive);
        fifthActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), TaskActivity.class);
                startActivity(i);
            }
        });

        /*Intent intent = new Intent(this,ShoppingActivity.class);
        startActivity(intent);*/
    }
}
