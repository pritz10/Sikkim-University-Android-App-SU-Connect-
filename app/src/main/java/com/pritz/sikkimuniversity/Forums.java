package com.pritz.sikkimuniversity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
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

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import static android.R.id.message;


public class Forums extends AppCompatActivity{
    EditText editText;
    ListView list;
    TextToSpeech t1;
    FirebaseListAdapter firebaseListAdapter;
    DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("forums");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forums);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });


        editText = (EditText) findViewById(R.id.editText2);
        list = (ListView) findViewById(R.id.list);
        final String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=editText.getText().toString();
                s=currentDateTimeString+"\n"+s;
               String d="Abhisek \t"+"(Horticulture)";
              Chat chat = new Chat(d,s);

                Map<String,Object> values = new HashMap<>();
                values.put("name", "Pritam");
                values.put("message", message);
                mref.push().setValue(chat);
                editText.setText("");

            }
        });


        final List<Chat> listmes = new LinkedList<>();


        final ArrayAdapter<Chat> adapter = new ArrayAdapter<Chat>
                (this,android.R.layout.two_line_list_item, listmes) {
            @Override
            public View getView(int pos, View view, ViewGroup parent) {
                if (view == null)
                {
                    view = getLayoutInflater().inflate(android.R.layout.two_line_list_item, parent, false);
                }
                Chat chat = listmes.get(pos);

                ((TextView) view.findViewById(android.R.id.text1)).setText(chat.getName());
                ((TextView) view.findViewById(android.R.id.text2)).setText(chat.getMess());


                return view;

            }
        };
        list.setAdapter(adapter);



        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Chat chat=dataSnapshot.getValue(Chat.class);
                listmes.add(chat);
                adapter.notifyDataSetChanged();
                t1.speak(chat.getName(), TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(Forums.this, "Message sent...", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(Forums.this, "HELP", Toast.LENGTH_SHORT).show();

            }
        });

    }
}

