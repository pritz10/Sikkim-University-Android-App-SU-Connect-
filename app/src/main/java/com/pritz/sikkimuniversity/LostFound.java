package com.pritz.sikkimuniversity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LostFound extends AppCompatActivity {
private RecyclerView postinsta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_found);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
postinsta=(RecyclerView) findViewById(R.id.postinsta);
        postinsta.setHasFixedSize(true);
        postinsta.setLayoutManager(new LinearLayoutManager(this));

    }

}
