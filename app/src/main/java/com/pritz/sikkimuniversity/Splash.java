package com.pritz.sikkimuniversity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.io.File;

@SuppressLint("NewApi")
public class Splash extends AppCompatActivity {
    public FirebaseAuth auth;
    File gotyou;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        auth= FirebaseAuth.getInstance();
        gotyou = new File("/data/data/com.pritz.sikkimuniversity/shared_prefs/userinfo.xml");
    }
    @Override
    public void onStart() {
        super.onStart();
        Thread t =new Thread(){
            public void run(){
                try{
                     sleep(500);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    if(auth.getCurrentUser()!=null)
                    {
                        if (gotyou.exists())
                        {
                            Intent intent = new Intent(Splash.this, MainFragmenthome.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    else
                    {
                        Intent i =new Intent(Splash.this,Login.class);
                        startActivity(i);
                    }
                }
            }
        };
        t.start();

    }

    @Override
    public void onPause(){
        super.onPause();
        finish();
    }

}
