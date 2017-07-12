package com.pritz.sikkimuniversity;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class lol extends AppCompatActivity {
    EditText editText;
    ListView listView;
    TextToSpeech t1;
    forumss ra;
    String d="hello";
    DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("forums");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lol_main);

        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        final String name = sharedPreferences.getString("s_name","");

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        editText = (EditText) findViewById(R.id.editText2);
        listView = (ListView) findViewById(R.id.listview);
        final String date = DateFormat.getDateTimeInstance().format(new Date());
         final String message=editText.getText().toString();
        final GetterandSetter getterandSetter = new GetterandSetter(name,date,message);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String message=editText.getText().toString();

                final GetterandSetter getterandSetter = new GetterandSetter(name,date,message);
                //String d="Pritam Shah \t"+"(Computer Aplications)";


                Map<String,Object> values = new HashMap<>();
                values.put("name", "Pritam");
                values.put("date",date);
                values.put("message", message);
                mref.push().setValue(getterandSetter);
                editText.setText("");

            }
        });
        ra = new forumss(getApplicationContext(), R.layout.formlayout);
        listView.setAdapter(ra);
        ra.add(getterandSetter);

        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                GetterandSetter getterandSetter=dataSnapshot.getValue(GetterandSetter.class);
                ra.add(getterandSetter);
                t1.speak(getterandSetter.getname(), TextToSpeech.QUEUE_FLUSH, null);
                ra.notifyDataSetChanged();


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(lol.this, "HELP", Toast.LENGTH_SHORT).show();

            }
        });

    }
    }

