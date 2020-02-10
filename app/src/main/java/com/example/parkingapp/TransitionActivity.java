package com.example.parkingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class TransitionActivity extends AppCompatActivity {
    private static final String[] PARKING_LOCATIONS = new String[]{
            "Roble Parking Garage", "Wilbur Parking Garage", "Maples Parking"
    };

    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        AutoCompleteTextView parkingLocation = findViewById(R.id.actvLocation);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, PARKING_LOCATIONS);
        parkingLocation.setAdapter(adapter);

        searchButton = (Button)findViewById(R.id.btSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFindParking(v);
            }
        });
    }

    public void onFindParking(View view){
        Intent intent = new Intent(this, SpotDisplayActivity.class);
        startActivity(intent);
    }
}
