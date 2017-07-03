package com.pritz.sikkimuniversity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ProfessionalStudies extends AppCompatActivity {
    int[] image1 = {R.mipmap.prof_a_dutta,R.mipmap.appallla_nag_shankar,R.mipmap.s_s_mahapatra,R.mipmap.bivek_tamang,R.mipmap.r_basnet,R.mipmap.b_muthupandian,};
    int[] image2 = {R.mipmap.tj_raju,R.mipmap.anju_verma,R.mipmap.dr_subash_misra,R.mipmap.dr_vimal_kishor};
    int[] image3 = {R.mipmap.dr_v_rama_devi,R.mipmap.shailendra_kumar,R.mipmap.pradip_kumar_das,R.mipmap.dr_a_ravi_prakash,R.mipmap.dr_krishna_murari,R.mipmap.r_rai};
    int[] image4 = {R.mipmap.silajit_guha,R.mipmap.manoj_das,R.mipmap.jasmine_yimchunger};
    int[] image5 = {R.mipmap.krishnendu_dutta,R.mipmap.jayanta_barman,R.mipmap.samidha_vedabala,R.mipmap.santosh_kumar};
    int[] image6 = {R.mipmap.ms_ashi_pempem_wangmo,R.mipmap.mr_jigme_wangchuk_bhutia};
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
        getSupportActionBar().setTitle("School of Professional Studies");
        Intent intent = getIntent();
        int deptname = intent.getIntExtra("roger", 1);
        listView = (ListView) findViewById(R.id.list_view);
        if (deptname == 0) {
            getSupportActionBar().setTitle("Department of Commerce");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._5Designation1);
            teacher_name = getResources().getStringArray(R.array._5teachers_name1);
            emailid = getResources().getStringArray(R.array._5email1);
            Phno = getResources().getStringArray(R.array._5PhoneNumber1);
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
            getSupportActionBar().setTitle("Department of Education");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._5Designation2);
            teacher_name = getResources().getStringArray(R.array._5teachers_name2);
            emailid = getResources().getStringArray(R.array._5email2);
            Phno = getResources().getStringArray(R.array._5PhoneNumber2);
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
            getSupportActionBar().setTitle("Department of Management");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._5Designation3);
            teacher_name = getResources().getStringArray(R.array._5teachers_name3);
            emailid = getResources().getStringArray(R.array._5email3);
            Phno = getResources().getStringArray(R.array._5PhoneNumber3);
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
            getSupportActionBar().setTitle("Department of Mass Communication");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._5Designation4);
            teacher_name = getResources().getStringArray(R.array._5teachers_name4);
            emailid = getResources().getStringArray(R.array._5email4);
            Phno = getResources().getStringArray(R.array._5PhoneNumber4);
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
            getSupportActionBar().setTitle("Department of Music");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._5Designation5);
            teacher_name = getResources().getStringArray(R.array._5teachers_name5);
            emailid = getResources().getStringArray(R.array._5email5);
            Phno = getResources().getStringArray(R.array._5PhoneNumber5);
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
            getSupportActionBar().setTitle("Department of Tourism");

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._5Designation6);
            teacher_name = getResources().getStringArray(R.array._5teachers_name6);
            emailid = getResources().getStringArray(R.array._5email6);
            Phno = getResources().getStringArray(R.array._5PhoneNumber6);
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
    }
}
