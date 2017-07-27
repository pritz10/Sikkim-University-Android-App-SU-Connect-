package com.pritz.sikkimuniversity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SingleItemView extends Activity {
    // Declare Variables
    ImageButton txtrank;
    TextView txtcountry;
    String rank;
    String country;
    String population;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();
        // Get the results of rank
        rank = i.getStringExtra("rank");
        // Get the results of country
        country = i.getStringExtra("country");
        // Get the results of population
        population = i.getStringExtra("population");

        // Locate the TextViews in singleitemview.xml
        txtrank = (ImageButton)findViewById(R.id.rank);
        txtcountry = (TextView) findViewById(R.id.country);

        // Load the results into the TextViews
        txtcountry.setText(country);
    }
}