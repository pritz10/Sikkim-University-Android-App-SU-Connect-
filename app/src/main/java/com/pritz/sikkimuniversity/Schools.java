package com.pritz.sikkimuniversity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Toolbar;


public class Schools extends AppCompatActivity {
    String[] schools ={"School of Human Sciences",
    "School of Language And Litreture",
    "School of Life Sciences",
    "School of Physical Sciences",
    "School of Professional Studies",
    "School of Social Sciences"};
    ListView listView;
    List_School lc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools);
        getSupportActionBar().setTitle("Schools");
        listView= (ListView) findViewById(R.id.simplelist);
        int i = 0;
        lc = new List_School(getApplicationContext(), R.layout.layout_of_schools);
        listView.setAdapter(lc);
        TeacherDetailsProvider tdp1;
        for (String id : schools) {
            tdp1 = new TeacherDetailsProvider(schools[i]);
            lc.add(tdp1);
            i++;
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent x = new Intent(Schools.this,Department_list.class);
                x.putExtra("dept_names", position);
                startActivity(x);
            }
        });

    }
}
