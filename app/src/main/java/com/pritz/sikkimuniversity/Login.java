package com.pritz.sikkimuniversity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    public EditText inputEmail, inputPassword;
    public FirebaseAuth auth;
    FirebaseUser user;
    public String uid;
    public DatabaseReference mdatabase;

    public FirebaseAuth.AuthStateListener authStateListener;
    private ProgressBar progressBar;
    private Button gosignup, gologin, goreset;
    String email, password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_login);
      /*try {
            String ps= FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
            if (ps.equals("pritamshah1010@gmail.com"))
            {
                Intent intent = new Intent(Login.this,Admin.class);
                startActivity(intent);
            }
            else if(FirebaseAuth.getInstance().getCurrentUser()!=null)
            {
                Intent intent = new Intent(Login.this,Admin.class);
                startActivity(intent);
            }
        }
        catch (Exception e)
        {

        }*/

        inputEmail =  (EditText) findViewById(R.id.email);
        inputPassword =  (EditText)  findViewById(R.id.password);
        progressBar =  (ProgressBar) findViewById(R.id.progressBar);

        gologin=(Button) findViewById(R.id.btn_loginn);
        goreset=(Button) findViewById(R.id.btn_reset);
         auth= FirebaseAuth.getInstance();
        authStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
             /*   if(firebaseAuth.getCurrentUser()!=null)
                {
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);

                }*/

            }
        };
        auth.addAuthStateListener(authStateListener);




        goreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, GetPassword.class));
            }
        });

        gologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = inputEmail.getText().toString().trim();
                password = inputPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this,new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (task.isSuccessful()) {
                                    try {
                                        Thread t =new Thread(){
                                            public void run(){
                                                try{
                                                    user = FirebaseAuth.getInstance().getCurrentUser();
                                                    if (user != null) {
                                                        uid = user.getUid();
                                                        mdatabase = FirebaseDatabase.getInstance().getReference().child("User").child(uid);
                                                        mdatabase.addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                String nmeh = dataSnapshot.child("name").getValue(String.class);
                                                                final String pheh = dataSnapshot.child("Department").getValue(String.class);

                                                                SharedPreferences got = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                                                                SharedPreferences.Editor editor = got.edit();
                                                                editor.putString("s_name", nmeh+"~"+pheh);
                                                                //editor.putString("s_dept",Department);
                                                                editor.apply();
                                                                progressBar.setVisibility(View.GONE);

                                                                Intent intent = new Intent(Login.this, MainFragmenthome.class);
                                                                    startActivity(intent);


                                                            }

                                                            @Override
                                                            public void onCancelled(DatabaseError databaseError) {

                                                            }
                                                        });

                                                    }
                                                    sleep(500);

                                                }catch(InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        };t.start();



                                    }
                                    catch (Exception e)
                                    {

                                    }


                                }
                            }
                        });
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        if(auth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(Login.this, MainFragmenthome.class);
            startActivity(intent);

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authStateListener != null) {
            auth.removeAuthStateListener(authStateListener);
        }
    }
    }
