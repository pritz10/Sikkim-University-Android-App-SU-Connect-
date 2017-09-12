package com.pritz.sikkimuniversity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class LifeSciences extends AppCompatActivity {
    int[] image1 = {R.mipmap.sathyanarayana,R.mipmap.dhani_raj_chhetri,R.mipmap.santosh_kumar_rai,R.mipmap.m_bijayalaxmi_devi,R.mipmap.arun_chettri,R.mipmap.ak_rai};
    int[] image2 = {R.mipmap.manivannan,R.mipmap.blodimae,R.mipmap.niladri_bag,R.mipmap.sujata,R.mipmap.manjurana,R.mipmap.blodimae,R.mipmap.r_kumar};
    int[] image3 = {R.mipmap.prof_j_p_tamang,R.mipmap.dr_hare_krishna,R.mipmap.bimala,R.mipmap.dr_nagendra_thakur,R.mipmap.buddhiman};
    int[] image4 = {R.mipmap.basundhara_chettri,R.mipmap.dr_bhoj_kumar_acharya,R.mipmap.dr_bisu_singh,R.mipmap.sudeep_ghatani};
    String[] teacher_name;
    String[] teacher_details;
    String[] emailid;
    String[] Phno;
    RowAdapter ra;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languageand_litreature);
        getSupportActionBar().setTitle("School of Human Science");
        Intent intent = getIntent();
        int deptname = intent.getIntExtra("roger", 1);
        listView = (ListView) findViewById(R.id.list_view);
        if (deptname == 0) {
            getSupportActionBar().setTitle("Department of Botany");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._3Designation1);
            teacher_name = getResources().getStringArray(R.array._3teachers_name1);
            emailid = getResources().getStringArray(R.array._3email1);
            Phno = getResources().getStringArray(R.array._3PhoneNumber1);
            int i = 0;
            ra = new RowAdapter(getApplicationContext(), R.layout.custom_view);
            listView.setAdapter(ra);
            TeacherDetailsProvider tdp;
            for (String id : teacher_name) {
                tdp = new TeacherDetailsProvider(image1[i], id, teacher_details[i], Phno[i], emailid[i]);
                ra.add(tdp);
                i++;
            }
        }
        if (deptname == 1) {
            getSupportActionBar().setTitle("Department of Horticulture");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._3Designation2);
            teacher_name = getResources().getStringArray(R.array._3teachers_name2);
            emailid = getResources().getStringArray(R.array._3email2);
            Phno = getResources().getStringArray(R.array._3PhoneNumber2);
            int i = 0;
            ra = new RowAdapter(getApplicationContext(), R.layout.custom_view);
            listView.setAdapter(ra);
            TeacherDetailsProvider tdp;
            for (String id : teacher_name) {
                tdp = new TeacherDetailsProvider(image2[i], id, teacher_details[i], Phno[i], emailid[i]);
                ra.add(tdp);
                i++;
            }
        }
        if (deptname == 2) {
            getSupportActionBar().setTitle("Department of Microbiology");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._3Designation3);
            teacher_name = getResources().getStringArray(R.array._3teachers_name3);
            emailid = getResources().getStringArray(R.array._3email3);
            Phno = getResources().getStringArray(R.array._3PhoneNumber3);
            int i = 0;
            ra = new RowAdapter(getApplicationContext(), R.layout.custom_view);
            listView.setAdapter(ra);
            TeacherDetailsProvider tdp;
            for (String id : teacher_name) {
                tdp = new TeacherDetailsProvider(image3[i], id, teacher_details[i], Phno[i], emailid[i]);
                ra.add(tdp);
                i++;
            }
        }
        if(deptname == 3){
            getSupportActionBar().setTitle("Department of Zoology");

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._3Designation4);
            teacher_name = getResources().getStringArray(R.array._3teachers_name4);
            emailid = getResources().getStringArray(R.array._3email4);
            Phno = getResources().getStringArray(R.array._3PhoneNumber4);
            int i = 0;
            ra = new RowAdapter(getApplicationContext(), R.layout.custom_view);
            listView.setAdapter(ra);
            TeacherDetailsProvider tdp;
            for (String id : teacher_name) {
                tdp = new TeacherDetailsProvider(image4[i], id, teacher_details[i], Phno[i], emailid[i]);
                ra.add(tdp);
                i++;
            }
        }

    }
}
