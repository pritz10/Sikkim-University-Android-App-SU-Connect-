package com.pritz.sikkimuniversity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainFragmenthome extends AppCompatActivity implements fragmentNoticeBoard.OnFragmentInteractionListener{

    private TextView mTextMessage;

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
                    Intent intent = new Intent(getApplicationContext(), Testingstory.class);
                    startActivity(intent); // mTextMessage.setText("Contacts");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainfragmenthome);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.menuforbottomnavigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        MainFragment c=new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content,c).commit();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dev, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.ex) {
            Exit();
            return true;
        }

        if(id==R.id.ml)
        {
            Intent intent=new Intent(getApplication(),Aboout_App.class); // Message from VC
            startActivity(intent);
        }
        if(id==R.id.cl)
        {
            Intent intent=new Intent(getApplication(),Developers.class); // Location of SU
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    public void Exit()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //builder.setTitle("Exit");
        builder.setMessage("Are you sure you want to Exit ?");
        builder.setPositiveButton("No",null);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                //bt.disable();
                finish();
                System.exit(0);
            }
        });
        builder.create();
        builder.show();
    }


}


