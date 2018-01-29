package com.pritz.sikkimuniversity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private Button login;
private FirebaseAuth mauth;
    private DatabaseReference mda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Login..");
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        mda=FirebaseDatabase.getInstance().getReference().child("user");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checklogin();
            }
        });
    }


    public void checklogin()
    {
    String emailf=email.getText().toString().trim();
        String password=pass.getText().toString().trim();
        if(!TextUtils.isEmpty(emailf) && !TextUtils.isEmpty(password))
        {
            mauth.signInWithEmailAndPassword(emailf,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful())
               {
                   checkuserexist();
               }
                    else {
               Toast.makeText(Register.this,"ERROE LOGIN",Toast.LENGTH_SHORT);
                    }
               }

            });
        }
    }
    public void checkuserexist()

    {
final String user_id=mauth.getCurrentUser().getUid();
        mda.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
           if(dataSnapshot.hasChild(user_id)){
               Intent intent=new Intent(Register.this,MainActivity.class);
               intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
               startActivity(intent);

           }
                else{Toast.makeText(Register.this,"You need to setup Account",Toast.LENGTH_SHORT);}
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}