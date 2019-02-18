package com.pritz.sikkimuniversity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import static android.R.attr.x;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,Mainnotice.OnFragmentInteractionListener {

private ViewPager mviewpager;
private SectionsPagerAdapter sectionpager;
private TabLayout mtablayout;

   @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //  Intent intent = getIntent();
       NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       View hView = navigationView.getHeaderView(0);
       TextView nav_user = (TextView)hView.findViewById(R.id.username1);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("A Central University established by an Act of Parliament of India,2007");
        mviewpager=(ViewPager) findViewById(R.id.mpager);
        sectionpager=new SectionsPagerAdapter(getSupportFragmentManager());

        mviewpager.setAdapter(sectionpager);
        mtablayout=(TabLayout) findViewById(R.id.maintabs);
        mtablayout.setupWithViewPager(mviewpager);

       NotificationEventReceiver.setupAlarm(getApplicationContext());



       SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
       String name = sharedPreferences.getString("s_name","");
       nav_user.setText(name);
      /* Mainnotice c=new Mainnotice();
       getSupportFragmentManager().beginTransaction()
               .replace(R.id.content,c).commit();*/

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Admin.class);
                startActivity(intent);
            }
        });
       FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fab3);
       fab3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(), handwriting.class);
               startActivity(intent);
           }
       });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

         navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.department) {
            Intent intent=new Intent(getApplicationContext(),Schools.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.libsu) {
            Intent intent=new Intent(getApplicationContext(),LibSu.class);
            startActivity(intent);


        } else if (id == R.id.lost) {

            Intent intent=new Intent(getApplicationContext(),LostFound.class);
            startActivity(intent);
        } else if (id == R.id.susa) {
            Intent intent=new Intent(getApplicationContext(),SUSA.class);
            startActivity(intent);

        } else if (id == R.id.fourms) {
            Intent intent = new Intent(getApplicationContext(), Forums.class);
            intent.putExtra("name",x);
            startActivity(intent);
        }
            else if (id == R.id.pron) {
                Intent intent=new Intent(getApplicationContext(),Pronounce.class);
                startActivity(intent);

        }
        else if(id==R.id.gallery)
        {
            Intent intent=new Intent(getApplication(),Blood.class); // Antiragging
            startActivity(intent);
        }
        else if (id == R.id.contact) {

            Intent intent = new Intent(getApplicationContext(), contact_book.class);
            startActivity(intent);
        }
        else if (id == R.id.help) {
            Intent intent = new Intent(getApplicationContext(),help.class);
            startActivity(intent);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
