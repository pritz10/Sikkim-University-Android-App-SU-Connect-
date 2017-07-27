package com.pritz.sikkimuniversity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class HumanScience extends AppCompatActivity {
    int[] image1 = {R.mipmap.kotra_mohan, R.mipmap.dr_maibam_samson_singh, R.mipmap.dr_charisma_k_lepcha};//not suggested
    int[] image2 = {R.mipmap.drsohelfirdos, R.mipmap.druttamlal, R.mipmap.drrafiulahmed, R.mipmap.elangbam_ishwarjit_singh, R.mipmap.abdul_hannan, R.mipmap.vimal_khawas};
    int[] image3 = {R.mipmap.nutankumar_thingujam, R.mipmap.drsatyanandapanda, R.mipmap.drsaurabhmaheshwari, R.mipmap.namrata_p};
    String[] teacher_name;
    String[] teacher_details;
    String[] emailid;
    String[] Phno;
    RowAdapter ra;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_science);


        Intent intent = getIntent();
        int deptname = intent.getIntExtra("roger", 1);
        listView = (ListView) findViewById(R.id.list_view);
        if (deptname == 0) {
            getSupportActionBar().setTitle("Department of Anthropology");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._1Designation1);
            teacher_name = getResources().getStringArray(R.array._1teachers_name1);
            emailid = getResources().getStringArray(R.array._1email1);
            Phno = getResources().getStringArray(R.array._1PhoneNumber1);
            int i = 0;
            ra = new RowAdapter(getApplicationContext(), R.layout.costum_view);
            listView.setAdapter(ra);
            TeacherDetailsProvider tdp;
            for (String id : teacher_name) {
                tdp = new TeacherDetailsProvider(image1[i], id, teacher_details[i], Phno[i], emailid[i]);
                ra.add(tdp);
                i++;
            }
        }
        if (deptname == 1) {
            getSupportActionBar().setTitle("Department of Geography");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._1Designation2);
            teacher_name = getResources().getStringArray(R.array._1teachers_name2);
            emailid = getResources().getStringArray(R.array._1email2);
            Phno = getResources().getStringArray(R.array._1PhoneNumber2);
            int i = 0;
            ra = new RowAdapter(getApplicationContext(), R.layout.costum_view);
            listView.setAdapter(ra);
            TeacherDetailsProvider tdp;
            for (String id : teacher_name) {
                tdp = new TeacherDetailsProvider(image2[i], id, teacher_details[i], Phno[i], emailid[i]);
                ra.add(tdp);
                i++;
            }
        }
        if (deptname == 2) {
            getSupportActionBar().setTitle("Department of Psychology");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._1Designation3);
            teacher_name = getResources().getStringArray(R.array._1teachers_name3);
            emailid = getResources().getStringArray(R.array._1email3);
            Phno = getResources().getStringArray(R.array._1PhoneNumber3);
            int i = 0;
            ra = new RowAdapter(getApplicationContext(), R.layout.costum_view);
            listView.setAdapter(ra);
            TeacherDetailsProvider tdp;
            for (String id : teacher_name) {
                tdp = new TeacherDetailsProvider(image3[i], id, teacher_details[i], Phno[i], emailid[i]);
                ra.add(tdp);
                i++;
            }
        }
    }
}