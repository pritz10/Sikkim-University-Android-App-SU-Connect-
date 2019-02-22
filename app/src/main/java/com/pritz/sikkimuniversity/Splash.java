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

@SuppressLint("NewApi")
public class Splash extends AppCompatActivity {
    public FirebaseAuth auth;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        auth= FirebaseAuth.getInstance();
        Toast.makeText(getApplicationContext(), "Splash", Toast.LENGTH_SHORT).show();

        final MediaPlayer mp=MediaPlayer.create(this,R.raw.lg);

        Thread t =new Thread(){
            public void run(){
                try{
                    mp.start();
                    sleep(500);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent i =new Intent(Splash.this,Login.class);
                    startActivity(i);
                }
            }
        };
        t.start();
    }
    @Override
    public void onStart() {
        super.onStart();
        if(auth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(Splash.this, MainFragmenthome.class);
            startActivity(intent);
            finish();

        }
        else
        {
            Intent i =new Intent(Splash.this,Login.class);
            startActivity(i);

        }
    }

    @Override
    public void onPause(){
        super.onPause();
        finish();
    }

}
