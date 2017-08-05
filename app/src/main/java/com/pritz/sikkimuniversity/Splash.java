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

@SuppressLint("NewApi")
public class Splash extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final MediaPlayer mp=MediaPlayer.create(this,R.raw.lg);

        getSupportActionBar().hide();
        Thread t =new Thread(){
            public void run(){
                try{
                    mp.start();
                    sleep(1500);

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
    public void onPause(){
        super.onPause();
        finish();
    }

}
