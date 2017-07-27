package com.pritz.sikkimuniversity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.MediaActionSound;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
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


public class  Forums extends AppCompatActivity{
    EditText editText;
    ListView listView;
    TextToSpeech t1;
    forumss ra;


    DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("forums");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forums);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chat Room");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.sentmessage);

        // Intent intent = getIntent();
        //final String x = intent.getStringExtra("name");

        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        final String name = sharedPreferences.getString("s_name","");

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });

        editText = (EditText) findViewById(R.id.editText2);
        listView = (ListView) findViewById(R.id.listview);
        final String date = DateFormat.getDateTimeInstance().format(new Date());
        final String message=editText.getText().toString();
        final GetterandSetter getterandSetter = new GetterandSetter(name,date,message);
        ra = new forumss(getApplicationContext(), R.layout.formlayout);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 String message=editText.getText().toString();
               // message=message+"\nAug 31,2017 9:32:24 Pm";
                if (!TextUtils.isEmpty(message))
                {
                    final GetterandSetter getterandSetter = new GetterandSetter(name,date,message);
                    //String d="Pritam Shah \t"+"(Computer Aplications)";
                    Map<String,Object> values = new HashMap<>();
                    values.put("name", "Pritam");
                    values.put("date",date);
                    values.put("message",message);
                    mref.push().setValue(getterandSetter);
                    editText.setText("");

mp.start();
                }

            }
        });

        FirebaseListAdapter<GetterandSetter> adapter=new FirebaseListAdapter<GetterandSetter>(this, GetterandSetter.class, R.layout.formlayout,mref) {
            @Override
            protected void populateView(View v, GetterandSetter model, int position)
            {
                TextView date_,name_;
                EditText mainframe_;
                mainframe_=(EditText)v.findViewById(R.id.mainframe);
                date_=(TextView)v.findViewById(R.id.date);
                name_=(TextView)v.findViewById(R.id.name);
                mainframe_.setText(model.getMessage());
                name_.setText(model.getname());
                date_.setText(model.getDate());



            }
        };

       /* NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.journaldev.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.sul));
        builder.setContentTitle(getterandSetter.getname());
        builder.setContentText(getterandSetter.getMessage());
        builder.setSubText("Tap to view the website.");

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Will display the notification in the notification bar
        notificationManager.notify(1, builder.build());
        t1.speak(getterandSetter.getname(), TextToSpeech.QUEUE_FLUSH, null);*/
        //progressBar.setVisibility(View.GONE);
        listView.setAdapter(adapter);

        //ra.add(getterandSetter);



    }
}

