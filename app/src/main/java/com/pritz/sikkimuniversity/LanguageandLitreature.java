package com.pritz.sikkimuniversity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class LanguageandLitreature extends AppCompatActivity {
    int[] image1 = {R.mipmap.bhaichungbhai, R.mipmap.drhissay};
    int[] image2 = {R.mipmap.dhriti_roy, R.mipmap.irfan_ahmad, R.mipmap.mr_moromti_baroowa};
    int[] image3 = {R.mipmap.irshad, R.mipmap.jayita, R.mipmap.r_chamling};
    int[] image4 = {R.mipmap.mr_dinesh_shahu, R.mipmap.mrs_chunkey};
    int[] image5 = {R.mipmap.dukmit_lepcha, R.mipmap.kachyo_lepcha};
    int[] image6 = {R.mipmap.kausila_subba, R.mipmap.tej_raj_limboo};
    int[] image7 ={R.mipmap.pratap_chandra, R.mipmap.dr_kabita_lama, R.mipmap.pushpa, R.mipmap.samar_sinha, R.mipmap.dr_subba, R.mipmap.balaram_pandey};
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
        getSupportActionBar().setTitle("School of Language and Literature");
        Intent intent = getIntent();
        int deptname = intent.getIntExtra("roger", 1);
        listView = (ListView) findViewById(R.id.list_view);
        if (deptname == 0) {

            getSupportActionBar().setTitle("Department of Bhutia");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._2Designation1);
            teacher_name = getResources().getStringArray(R.array._2teachers_name1);
            emailid = getResources().getStringArray(R.array._2email1);
            Phno = getResources().getStringArray(R.array._2PhoneNumber1);
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
            getSupportActionBar().setTitle("Department of Chinese");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._2Designation2);
            teacher_name = getResources().getStringArray(R.array._2teachers_name2);
            emailid = getResources().getStringArray(R.array._2email2);
            Phno = getResources().getStringArray(R.array._2PhoneNumber2);
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
            getSupportActionBar().setTitle("Department of English");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._2Designation3);
            teacher_name = getResources().getStringArray(R.array._2teachers_name3);
            emailid = getResources().getStringArray(R.array._2email3);
            Phno = getResources().getStringArray(R.array._2PhoneNumber3);
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
            getSupportActionBar().setTitle("Department of Hindi");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._2Designation4);
            teacher_name = getResources().getStringArray(R.array._2teachers_name4);
            emailid = getResources().getStringArray(R.array._2email4);
            Phno = getResources().getStringArray(R.array._2PhoneNumber4);
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
        if(deptname == 4){
            getSupportActionBar().setTitle("Department of Lepcha");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._2Designation5);
            teacher_name = getResources().getStringArray(R.array._2teachers_name5);
            emailid = getResources().getStringArray(R.array._2email5);
            Phno = getResources().getStringArray(R.array._2PhoneNumber5);
            int i = 0;
            ra = new RowAdapter(getApplicationContext(), R.layout.custom_view);
            listView.setAdapter(ra);
            TeacherDetailsProvider tdp;
            for (String id : teacher_name) {
                tdp = new TeacherDetailsProvider(image5[i], id, teacher_details[i], Phno[i], emailid[i]);
                ra.add(tdp);
                i++;
            }
        }
        if(deptname == 5){
            getSupportActionBar().setTitle("Department of Limboo");

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._2Designation6);
            teacher_name = getResources().getStringArray(R.array._2teachers_name6);
            emailid = getResources().getStringArray(R.array._2email6);
            Phno = getResources().getStringArray(R.array._2PhoneNumber6);
            int i = 0;
            ra = new RowAdapter(getApplicationContext(), R.layout.custom_view);
            listView.setAdapter(ra);
            TeacherDetailsProvider tdp;
            for (String id : teacher_name) {
                tdp = new TeacherDetailsProvider(image6[i], id, teacher_details[i], Phno[i], emailid[i]);
                ra.add(tdp);
                i++;
            }
        }
        if(deptname == 6){
            getSupportActionBar().setTitle("Department of Nepali");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._2Designation7);
            teacher_name = getResources().getStringArray(R.array._2teachers_name7);
            emailid = getResources().getStringArray(R.array._2email7);
            Phno = getResources().getStringArray(R.array._2PhoneNumber7);
            int i = 0;
            ra = new RowAdapter(getApplicationContext(), R.layout.custom_view);
            listView.setAdapter(ra);
            TeacherDetailsProvider tdp;
            for (String id : teacher_name) {
                tdp = new TeacherDetailsProvider(image7[i], id, teacher_details[i], Phno[i], emailid[i]);
                ra.add(tdp);
                i++;
            }
        }
    }
}
