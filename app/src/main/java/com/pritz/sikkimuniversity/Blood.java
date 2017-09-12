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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
 import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.squareup.picasso.Picasso;

import java.io.File;

import static com.pritz.sikkimuniversity.R.id.pico;


public class Blood extends AppCompatActivity {

    private RecyclerView postinsta;
    private DatabaseReference mdatabase;
    ProgressBar progressBar1;

     ArrayAdapter<CharSequence> adapter;
    File gotyou = new File("/data/data/com.pritz.sikkimuniversity/shared_prefs/blodgr.xml");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);
     //   getSupportActionBar().setTitle("SU Blood Donors");
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar);
        progressBar1.setVisibility(View.VISIBLE);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("blood_donation");
        postinsta = (RecyclerView) findViewById(R.id.blodlife);
        postinsta.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
         mdatabase.keepSynced(true);
        postinsta.setLayoutManager(mLayoutManager);

    }
    @Override
    protected void onStart() {
        super.onStart();
      FirebaseRecyclerAdapter<blood,BlogViewholder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<blood,BlogViewholder>(
              blood.class,R.layout.blod,BlogViewholder.class,mdatabase.orderByChild("blodgrp").startAt("A")
      ) {
          @Override
          protected void populateViewHolder(BlogViewholder viewHolder, blood model, int position) {
              viewHolder.setName(model.getName());
              viewHolder.setImage(getApplicationContext(),model.getImage());
              viewHolder.setBlodgrp(model.getBlodgrp());
              final String pskey=getRef(position).getKey();
              progressBar1.setVisibility(View.GONE);
             viewHolder.view.setOnClickListener(new View.OnClickListener() {
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

        postinsta.setAdapter(firebaseRecyclerAdapter);
        mdatabase.keepSynced(true);
    }




    public static class BlogViewholder extends RecyclerView.ViewHolder{

        View view;
        public BlogViewholder(View itemView) {
            super(itemView);
            view=itemView;

        }
        public void setName(String name)
        {
            TextView blodgropu=(TextView)view.findViewById(R.id.name1);
            blodgropu.setText(name);
        }
        public void setBlodgrp(String blodgrp)        {
            TextView f=(TextView)view.findViewById(R.id.bldgrp);
            f.setText(blodgrp);
        }

        public void setImage(Context ctx, String image)
        {

            ImageView il=(ImageView)view.findViewById(pico);
            Picasso.with(ctx).load(image).resize(100,100).into(il);

        }



    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_forums, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.db) {
            if (gotyou.exists())
            {
                AlertDialog.Builder builder=new AlertDialog.Builder(this);

                builder.setMessage("You have chosen to donate your blood.Thanks For Your Cooperation.You are a real life hero. Salute to you. You will get a call when any one need blood. So if you are willing to give then you can donate otherwise you can tell them that you are not interested right now!");
                builder.setPositiveButton("Okay",null);
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
