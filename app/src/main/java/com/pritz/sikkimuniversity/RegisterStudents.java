package com.pritz.sikkimuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RegisterStudents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_students);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register to SU-Connect");
    }
}
