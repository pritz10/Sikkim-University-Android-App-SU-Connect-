package com.pritz.sikkimuniversity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomNavigation extends AppCompatActivity implements fragmentNoticeBoard.OnFragmentInteractionListener{

    private TextView mTextMessage;
public  ActionBar ab;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    MainFragment c=new MainFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,c).commit();
                    return true;
                case R.id.navigation_bus:
                    fragmentBus pl=new fragmentBus();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,pl).commit();
                    return true;
                case R.id.navigation_blood:
                    fragmentBlood p=new fragmentBlood();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,p).commit();
                    return true;
                case R.id.navigation_chat:
                    fragmentchats o=new fragmentchats();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,o).commit();
                    return true;
                case R.id.navigation_contacts:
                    // mTextMessage.setText("Contacts");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    public void onFragmentInteraction(String key) {
        String god=key;
        SharedPreferences sharedPreferences = getSharedPreferences("keyvalue", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("secret_key",god);
        editor.apply();
    }




    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    // To prevent crash on resuming activity  : interaction with fragments allowed only after Fragments Resumed or in OnCreate
    // http://www.androiddesignpatterns.com/2013/08/fragment-transaction-commit-state-loss.html
    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        // handleIntent();
    }

}


