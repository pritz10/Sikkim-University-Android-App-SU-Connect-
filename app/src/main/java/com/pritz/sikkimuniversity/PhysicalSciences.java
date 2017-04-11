package com.pritz.sikkimuniversity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class PhysicalSciences extends AppCompatActivity {
    int[] image1 = {R.mipmap.sudarsan_tamang,R.mipmap.somendranath_chakroborty,R.mipmap.biswajit_g_r};
    int[] image2 = {R.mipmap.mppradhan, R.mipmap.ppr1, R.mipmap.lekhikachettri, R.mipmap.rebikarai, R.mipmap.chunnukhawas};
    int[] image3 = {R.mipmap.rakesh_kumar_ranjan,R.mipmap.md_abdullah_khan,R.mipmap.nishchal_wanjar,R.mipmap.ananda_g_b,R.mipmap.op_kaptan};
    int[] image4 = {R.mipmap.dr_thoudem_roshan_singh,R.mipmap.ms_rinkila_bhutia};
    int[] image5 = {R.mipmap.dr_subir_mukhopadhay,R.mipmap.dr_amitabha_bhattacharyya,R.mipmap.dr_hemam_dinesh_singh,R.mipmap.dr_ajay_tripathi,R.mipmap.dr_archana_tiwari};
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
        getSupportActionBar().setTitle("School of Physical Sciences");
        Intent intent = getIntent();
        int deptname = intent.getIntExtra("roger", 1);
        listView = (ListView) findViewById(R.id.list_view);
        if (deptname == 0) {
            getSupportActionBar().setTitle("Department of Chemistry");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._4Designation1);
            teacher_name = getResources().getStringArray(R.array._4teachers_name1);
            emailid = getResources().getStringArray(R.array._4email1);
            Phno = getResources().getStringArray(R.array._4PhoneNumber1);
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
            getSupportActionBar().setTitle("Department of Computer Applications");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._4Designation2);
            teacher_name = getResources().getStringArray(R.array._4teachers_name2);
            emailid = getResources().getStringArray(R.array._4email2);
            Phno = getResources().getStringArray(R.array._4PhoneNumber2);
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
            getSupportActionBar().setTitle("Department of Geology");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._4Designation3);
            teacher_name = getResources().getStringArray(R.array._4teachers_name3);
            emailid = getResources().getStringArray(R.array._4email3);
            Phno = getResources().getStringArray(R.array._4PhoneNumber3);
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
        if (deptname == 3) {
            getSupportActionBar().setTitle("Department of Mathematics");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._4Designation4);
            teacher_name = getResources().getStringArray(R.array._4teachers_name4);
            emailid = getResources().getStringArray(R.array._4email4);
            Phno = getResources().getStringArray(R.array._4PhoneNumber4);
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
        if (deptname == 4) {
            getSupportActionBar().setTitle("Department of Physics");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._4Designation5);
            teacher_name = getResources().getStringArray(R.array._4teachers_name5);
            emailid = getResources().getStringArray(R.array._4email5);
            Phno = getResources().getStringArray(R.array._4PhoneNumber5);
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
    }
}