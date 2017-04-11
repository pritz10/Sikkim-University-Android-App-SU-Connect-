package com.pritz.sikkimuniversity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Department_list extends AppCompatActivity {

    String[] school;
    ListView listView;
    List_class lc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);

        Intent intent = getIntent();
        int getSchool = intent.getIntExtra("dept_names",1);
        if (getSchool == 0) {
            getSupportActionBar().setTitle("School of Human Science");
            school = getResources().getStringArray(R.array.SCHOOL_OF_HUMAN_SCIENCES);
            listView= (ListView) findViewById(R.id.list_view);
            int i = 0;
            lc = new List_class(getApplicationContext(), R.layout.layoutofdeptlist);
            listView.setAdapter(lc);
            TeacherDetailsProvider tdp1;
            for (String id : school) {
                tdp1 = new TeacherDetailsProvider(school[i]);
                lc.add(tdp1);
                i++;
            }
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent x = new Intent(Department_list.this,HumanScience.class);
                    x.putExtra("roger", position);
                     startActivity(x);
                }
            });
        }

    if(getSchool == 1) {
        getSupportActionBar().setTitle("School of Language and Literature");
        school = getResources().getStringArray(R.array.SCHOOL_OF_LANGUAGE_AND_LITERATURE);
        listView = (ListView) findViewById(R.id.list_view);
        int i = 0;
        lc = new List_class(getApplicationContext(), R.layout.layoutofdeptlist);
        listView.setAdapter(lc);
        TeacherDetailsProvider tdp1;
        for (String id : school) {
            tdp1 = new TeacherDetailsProvider(school[i]);
            lc.add(tdp1);
            i++;
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent x = new Intent(Department_list.this, LanguageandLitreature.class);
                x.putExtra("roger", position);
                startActivity(x);
            }
        });
    }

        if(getSchool == 2) {
            getSupportActionBar().setTitle("School of Life Sciences");
            school = getResources().getStringArray(R.array.SCHOOL_OF_LIFE_SCIENCES);
            listView = (ListView) findViewById(R.id.list_view);
            int i = 0;
            lc = new List_class(getApplicationContext(), R.layout.layoutofdeptlist);
            listView.setAdapter(lc);
            TeacherDetailsProvider tdp1;
            for (String id : school) {
                tdp1 = new TeacherDetailsProvider( id);
                lc.add(tdp1);
                i++;
            }
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent x = new Intent(Department_list.this,LifeSciences.class);
                    x.putExtra("roger", position);
                    startActivity(x);
                }
            });
        }
        if(getSchool == 3) {
            getSupportActionBar().setTitle("School of Physical Sciences");
            school = getResources().getStringArray(R.array.SCHOOL_OF_PHYSICAL_SCIENCES);
            listView = (ListView) findViewById(R.id.list_view);
            int i = 0;
            lc = new List_class(getApplicationContext(), R.layout.layoutofdeptlist);
            listView.setAdapter(lc);
            TeacherDetailsProvider tdp1;
            for (String id : school) {
                tdp1 = new TeacherDetailsProvider( id);
                lc.add(tdp1);
                i++;
            }
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent x = new Intent(Department_list.this, PhysicalSciences.class);
                    x.putExtra("roger", position);
                    startActivity(x);
                }
            });
        }
        if(getSchool == 4) {
            getSupportActionBar().setTitle("School of Professional Studies");
            school = getResources().getStringArray(R.array.SCHOOL_OF_PROFESSIONAL_STUDIES);
            listView = (ListView) findViewById(R.id.list_view);
            int i = 0;
            lc = new List_class(getApplicationContext(), R.layout.layoutofdeptlist);
            listView.setAdapter(lc);
            TeacherDetailsProvider tdp1;
            for (String id : school) {
                tdp1 = new TeacherDetailsProvider(id);
                lc.add(tdp1);
                i++;
            }
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent x = new Intent(Department_list.this,ProfessionalStudies.class);
                    x.putExtra("roger", position);
                    startActivity(x);
                }
            });
        }
        if(getSchool == 5) {
            getSupportActionBar().setTitle("School of Social Sciences");
            school = getResources().getStringArray(R.array.SCHOOL_OF_SOCIAL_SCIENCES);
            listView = (ListView) findViewById(R.id.list_view);
            int i = 0;
            lc = new List_class(getApplicationContext(), R.layout.layoutofdeptlist);
            listView.setAdapter(lc);
            TeacherDetailsProvider tdp1;
            for (String id : school) {
                tdp1 = new TeacherDetailsProvider(id);
                lc.add(tdp1);
                i++;
            }
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent x = new Intent(Department_list.this,SocialSciences.class);
                    x.putExtra("roger", position);
                    startActivity(x);
                }
            });
        }
     }
}
