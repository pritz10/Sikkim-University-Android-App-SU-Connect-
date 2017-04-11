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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_schools);

        getSupportActionBar().setTitle("Schools");
        listView=(ListView)findViewById(R.id.simplelist);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, schools);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent x= new Intent(Schools.this,Department_list.class);
                x.putExtra("dept_names",position);
                startActivity(x);
            }
        });

    }
}
