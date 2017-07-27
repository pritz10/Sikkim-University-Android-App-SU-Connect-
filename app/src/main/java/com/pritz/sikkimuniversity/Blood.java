package com.pritz.sikkimuniversity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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
    Spinner spinner;
    String bloodgroup;
private Query query;
    private DatabaseReference mdatabase;
    private DatabaseReference bld;
    ArrayAdapter<CharSequence> adapter;

    private StorageReference mStorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);
        getSupportActionBar().setTitle("SU Blood Donors");
        mdatabase= FirebaseDatabase.getInstance().getReference().child("blood_donation");
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.bloodgrp, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        final DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("blood_donation");
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        final String name = sharedPreferences.getString("s_name","");
        listView = (ListView) findViewById(R.id.listview);


        File gotyou = new File("/data/data/com.pritz.sikkimuniversity/shared_prefs/blodgr.xml");


         Button button=(Button)findViewById(R.id.button10);
        if (gotyou.exists())
        {
button.setOnClickListener(null);
            button.setText("You are a Real Life Hero");
        }

        else
        {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent intent=new Intent(Blood.this,Donate_Blood.class);
                    startActivity(intent);
                /*final String grp1=grp.getText().toString().toUpperCase();

                final blood b2= new blood(grp1,name);
                Map<String,Object> values = new HashMap<>();
                values.put("name", "Pritam");
                values.put("blood",grp1);
                mref.push().setValue(b2);
                grp.setText("");*/

                }
            });
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "", Toast.LENGTH_LONG).show();
                //bloodgroup = parent.getItemAtPosition(position) + "";
                bloodgroup = spinner.getSelectedItem().toString();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       /* if((!bloodgroup.equals("Enter Your Blood Group")))
        {
            //DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("blood_donation");

            query=mref.orderByChild("blodgrp").equalTo(bloodgroup);

        }*/
       // query =mref.limitToFirst(100);
        query=mref.orderByChild("blodgrp").equalTo("AB+");



        FirebaseListAdapter<blood> adapter=new FirebaseListAdapter<blood>(this, blood.class, R.layout.blod,query) {
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

                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getBaseContext(), pskey, Toast.LENGTH_LONG).show();
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
}
