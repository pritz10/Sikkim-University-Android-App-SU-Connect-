package com.pritz.sikkimuniversity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainFragmenthome extends AppCompatActivity implements fragmentNoticeBoard.OnFragmentInteractionListener{

    private TextView mTextMessage;
    boolean doubleBackToExitPressedOnce = false;

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
                    Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
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
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("s_name","");
        Toast.makeText(getApplicationContext(), "Hi\t"+name, Toast.LENGTH_SHORT).show();
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
            {finish();
                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(a);
            }
        });
        builder.create();
        builder.show();
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


}




