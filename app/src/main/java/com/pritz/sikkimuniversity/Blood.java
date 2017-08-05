package com.pritz.sikkimuniversity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.HashMap;
import java.util.Map;




public class Blood extends AppCompatActivity {
    ListView listView;
ProgressBar progressBar1;

    private DatabaseReference mdatabase;
    private DatabaseReference bld;
    ArrayAdapter<CharSequence> adapter;
    File gotyou = new File("/data/data/com.pritz.sikkimuniversity/shared_prefs/blodgr.xml");
    private StorageReference mStorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);
        getSupportActionBar().setTitle("SU Blood Donors");
        mdatabase= FirebaseDatabase.getInstance().getReference().child("blood_donation");
        progressBar1=(ProgressBar)findViewById(R.id.progressBar);

        final DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("blood_donation");

        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        final String name = sharedPreferences.getString("s_name","");
        listView = (ListView) findViewById(R.id.listview);







        FirebaseListAdapter<blood> adapter=new FirebaseListAdapter<blood>(this, blood.class, R.layout.blod,

                mref.orderByChild("blodgrp").startAt("A")) {




            @Override
            protected void populateView(View v, blood model, int position)
            {
                final String pskey=getRef(position).getKey();
                TextView name_,groiup;
                ImageView Pic;
                groiup=(TextView)v.findViewById(R.id.bldgrp);
                name_=(TextView)v.findViewById(R.id.name1);
                Pic=(ImageView)v.findViewById(R.id.pic);
                name_.setText(model.getName());
                groiup.setText(model.getBlodgrp());

                Picasso.with(getApplicationContext()).load(model.getImage()).into(Pic);
                progressBar1.setVisibility(View.GONE);

                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getBaseContext(), "Calling...", Toast.LENGTH_LONG).show();
mdatabase.child(pskey).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
String number=(String)dataSnapshot.child("Phone").getValue();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+number));
        startActivity(intent);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});

                    }
                });


            }
        };


        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forums, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.db) {
            if (gotyou.exists())
            {
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                //builder.setTitle("Exit");
                builder.setMessage("You have chosen to donate your blood.Thanks For Your Cooperation.You are a real life hero. Salute to you. You will get a call when any one need blood. So if you are willing to give then you can donate otherwise you can tell them that you are not interested right now!");
                builder.setPositiveButton("Okay",null);
              ;
                builder.create();
                builder.show();
            }

            else
            {

                        Intent intent=new Intent(Blood.this,Donate_Blood.class);
                        startActivity(intent);


            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    }
