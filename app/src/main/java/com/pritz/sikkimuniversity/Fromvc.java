package com.pritz.sikkimuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Fromvc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fromvc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("From the Vice-Chancellor’s Desk");

    }
}
