package com.example.parkingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class SpotDisplayActivity extends AppCompatActivity {
    /*private String[][] availableSpots = {
            {"Level 2", "3443293.230", "234892,43", "North side", "Permit C"},
            {"Level 3", "3443293.230", "234892,43", "East side", "Permit C"}};*/
    private static final String[] PARKING_LOCATIONS = new String[]{
            "Roble Parking Garage", "Wilbur Parking Garage", "Maples Parking"
    };
    private String[] availableSpots = {"Level 1", "Level 2", "Level 3"};

    /*ideally we have a mapping of all garage locations to all available spots that is being
    continuously updated */
    private Map<String, String> allLocations = new HashMap<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_display);

        ListView listView = (ListView) findViewById(R.id.lvSpots);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, availableSpots);
        listView.setAdapter(adapter);
    }
}
