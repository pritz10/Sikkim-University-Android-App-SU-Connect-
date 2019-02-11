package com.pritz.sikkimuniversity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentchats extends Fragment {
    EditText editText;
    ListView listView;
    TextToSpeech t1;
    ImageButton fab;
    DatabaseReference mref = FirebaseDatabase.getInstance().getReference().child("forums");


    public fragmentchats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmentchats, container, false);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


     //   SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
       // final String name = sharedPreferences.getString("s_name", "");


        editText = (EditText) getActivity().findViewById(R.id.editText2);
        listView = (ListView) getActivity().findViewById(R.id.listview);
        final String date = DateFormat.getDateTimeInstance().format(new Date());
        fab=(ImageButton) getActivity().findViewById(R.id.sendbtn);
        final String message = editText.getText().toString();
        final MediaPlayer mp=MediaPlayer.create(getContext(),R.raw.sentmessage);

        //    final GetterandSetter getterandSetter = new GetterandSetter(name, date, message);
        //ra = new forumss(getActivity().getApplicationContext(), R.layout.formlayout);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = editText.getText().toString();
                // message=message+"\nAug 31,2017 9:32:24 Pm";
                if (!TextUtils.isEmpty(message)) {
                    final GetterandSetter getterandSetter = new GetterandSetter("Pritam Shah(Computer Apps)", date, message);
                    //String d="Pritam Shah \t"+"(Computer Aplications)";
                    Map<String, Object> values = new HashMap<>();
                    values.put("name", "Pritam");
                    values.put("date", date);
                    values.put("message", message);
                    mref.push().setValue(getterandSetter);
                    editText.setText("");
                    mp.start();

                }

            }
        });

        FirebaseListAdapter<GetterandSetter> adapter = new FirebaseListAdapter<GetterandSetter>(getActivity(), GetterandSetter.class, R.layout.formlayout, mref) {
            @Override
            protected void populateView(View v, GetterandSetter model, int position) {
                TextView date_, name_;
                TextView mainframe_;
                mainframe_ =(TextView) v.findViewById(R.id.mainframe);
                date_ = (TextView) v.findViewById(R.id.date);
                name_ = (TextView) v.findViewById(R.id.name);
                mainframe_.setText(model.getMessage());
                name_.setText(model.getname());
                date_.setText(model.getDate());


            }
        };

        listView.setAdapter(adapter);

        //ra.add(getterandSetter);


    }
}

