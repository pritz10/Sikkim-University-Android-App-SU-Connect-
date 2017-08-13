package com.pritz.sikkimuniversity;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Important extends AppCompatActivity {
    TextView dat_,info_;
    ImageView immm;
    String dat;
    String  nam;
    String inf;
    String img;
    DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("Importantnotifications");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important);
        String gte= getIntent().getExtras().getString("gte");
        getSupportActionBar().setTitle("........");
       dat_=(TextView)findViewById(R.id.dat);
        info_=(TextView)findViewById(R.id.info);
        immm=(ImageView)findViewById(R.id.imm);
        mref.child(gte).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                  dat= (String) dataSnapshot.child("date").getValue();
                  nam=(String)dataSnapshot.child("name").getValue();
                  inf=(String)dataSnapshot.child("message").getValue();
                  img=(String)dataSnapshot.child("image").getValue();
                Picasso.with(Important.this).load(img).into(immm);

                getSupportActionBar().setTitle(nam);
                dat_.setText(dat);
                info_.setText(nam+"\n\n"+inf);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

   private ShareActionProvider mShareActionProvider;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        MenuItem item = menu.findItem(R.id.share);

        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        mShareActionProvider.setShareIntent(getDefaultShareIntent());

        return super.onCreateOptionsMenu(menu);

    }


    private Intent getDefaultShareIntent(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        //intent.putExtra(Intent.EXTRA_SUBJECT,"From SU-Connect Notice Board");
        intent.putExtra(Intent.EXTRA_TEXT,"From SU-Connect Notice Board\n\n"+dat+"\n"+nam+"\n\n"+inf+"\n\nDownload image\n\n"+img);
        return intent;
    }
}
