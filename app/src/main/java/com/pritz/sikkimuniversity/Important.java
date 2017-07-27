package com.pritz.sikkimuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Important extends AppCompatActivity {
    TextView dat_,info_;
    DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("Importantnotifications");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important);
        String gte=getIntent().getExtras().getString("gte");
        getSupportActionBar().setTitle("........");
       dat_=(TextView)findViewById(R.id.dat);
        info_=(TextView)findViewById(R.id.info);
        mref.child(gte).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String dat= (String) dataSnapshot.child("date").getValue();
                String  nam=(String)dataSnapshot.child("name").getValue();
                String inf=(String)dataSnapshot.child("message").getValue();
                getSupportActionBar().setTitle(nam);
                dat_.setText(dat);
                info_.setText(inf);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Toast.makeText(getBaseContext(), gte, Toast.LENGTH_LONG).show();
    }
}
