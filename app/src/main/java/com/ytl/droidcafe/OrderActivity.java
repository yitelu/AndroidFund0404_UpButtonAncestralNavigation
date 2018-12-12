package com.ytl.droidcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView mOrderTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        mOrderTV = findViewById(R.id.order_textView);

        if (intent.getStringExtra(MainActivity.EXTRA_MESSAGE) != null) {

            String order = "order: " + intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

            Log.d("order activity", "what u order: " + order);

            mOrderTV.setText(order);

        } else {
            mOrderTV.setText("ordered nothing");
        }


        Spinner spinner = findViewById(R.id.label_spinner);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if(spinner != null){
            spinner.setAdapter(adapter);
        }

    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.sameday:
                if (checked) {
                    displayToast(getString(R.string.same_day_messenger_service));
                }
                break;
            case R.id.nextday:
                if (checked) {
                    displayToast(getString(R.string.next_day_ground_delivery));
                }
                break;
            case R.id.pickup:
                if (checked) {
                    displayToast(getString(R.string.pick_up));
                }
                break;
            default:
                //Do nothing
                break;
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String spinnerLabel = parent.getItemAtPosition(position).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
