package com.ytl.droidcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    TextView mOrderTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        mOrderTV = findViewById(R.id.order_textView);

        if(intent.getStringExtra(MainActivity.EXTRA_MESSAGE) != null) {

            String order = "order: " + intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

            Log.d("order activity", "what u order: " + order);

            mOrderTV.setText(order);

        } else{
            mOrderTV.setText("ordered nothing");
        }
    }
}
