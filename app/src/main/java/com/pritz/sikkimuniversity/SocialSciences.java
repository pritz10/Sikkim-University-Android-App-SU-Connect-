package com.pritz.sikkimuniversity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class SocialSciences extends AppCompatActivity {
    int[] image1 = {R.mipmap.manesh,R.mipmap.komol,R.mipmap.dr_ruma_kundu,R.mipmap.pradyut,R.mipmap.rangalal};
    int[] image2 = {R.mipmap.ka,R.mipmap.vijay_k_thangellapali,R.mipmap.sangmu_thendup,R.mipmap.anira,R.mipmap.s_jeevanandam,R.mipmap.kr_devi};
    int[] image3 = {R.mipmap.manish,R.mipmap.sebastian,R.mipmap.newton};
    int[] image4 = {R.mipmap.ig_ahmed,R.mipmap.veer_mayank,R.mipmap.denkila_bhutia,R.mipmap.ns,R.mipmap.vijoy_v,R.mipmap.sonam_yangchen_bhutia};
    int[] image5 = {R.mipmap.nawal_k_paswan,R.mipmap.salvin_paul,R.mipmap.sanghamitra_choudhury};
    int[] image6 = {R.mipmap.durga_p_c,R.mipmap.bidhan_golay,R.mipmap.om_prasad_gadde,R.mipmap.amit_k_gupta,R.mipmap.budh_b_lama,R.mipmap.s_pradhan};
    int[] image7 = {R.mipmap.swati2,R.mipmap.dr_khangembam_indira,R.mipmap.sn_bagh};
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
        getSupportActionBar().setTitle("School of Social Sciences");
        Intent intent = getIntent();
        int deptname = intent.getIntExtra("roger", 1);
        listView = (ListView) findViewById(R.id.list_view);
        if (deptname == 0) {
            getSupportActionBar().setTitle("Department of Economics");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._6Designation1);
            teacher_name = getResources().getStringArray(R.array._6teachers_name1);
            emailid = getResources().getStringArray(R.array._6email1);
            Phno = getResources().getStringArray(R.array._6PhoneNumber1);
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
            getSupportActionBar().setTitle("Department of History");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._6Designation2);
            teacher_name = getResources().getStringArray(R.array._6teachers_name2);
            emailid = getResources().getStringArray(R.array._6email2);
            Phno = getResources().getStringArray(R.array._6PhoneNumber2);
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
            getSupportActionBar().setTitle("Department of International Relationship");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._6Designation3);
            teacher_name = getResources().getStringArray(R.array._6teachers_name3);
            emailid = getResources().getStringArray(R.array._6email3);
            Phno = getResources().getStringArray(R.array._6PhoneNumber3);
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
            getSupportActionBar().setTitle("Department of Law");

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._6Designation4);
            teacher_name = getResources().getStringArray(R.array._6teachers_name4);
            emailid = getResources().getStringArray(R.array._6email4);
            Phno = getResources().getStringArray(R.array._6PhoneNumber4);
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
            getSupportActionBar().setTitle("Department of Peace and Conflict");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._6Designation5);
            teacher_name = getResources().getStringArray(R.array._6teachers_name5);
            emailid = getResources().getStringArray(R.array._6email5);
            Phno = getResources().getStringArray(R.array._6PhoneNumber5);
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
            getSupportActionBar().setTitle("Department of Political Science");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._6Designation6);
            teacher_name = getResources().getStringArray(R.array._6teachers_name6);
            emailid = getResources().getStringArray(R.array._6email6);
            Phno = getResources().getStringArray(R.array._6PhoneNumber6);
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
            getSupportActionBar().setTitle("Department of Sociology");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            listView = (ListView) findViewById(R.id.list_view);
            teacher_details = getResources().getStringArray(R.array._6Designation7);
            teacher_name = getResources().getStringArray(R.array._6teachers_name7);
            emailid = getResources().getStringArray(R.array._6email7);
            Phno = getResources().getStringArray(R.array._6PhoneNumber7);
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