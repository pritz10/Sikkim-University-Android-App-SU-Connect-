package com.pritz.sikkimuniversity;

import android.app.AlertDialog;
import android.content.AbstractThreadedSyncAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ShareCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

int a=0;
    public ImageView imageButton;
public Button vcbtn;
    public Button loc;
    public Button up;
    public Button CAL;
    public Button advr;
    public Button ir;
    public Button con;
    public Button ant;
   @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("A Central University established by an Act of Parliament of India,2007");
       vcbtn=(Button)findViewById(R.id.vcbtn);
       vcbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getApplication(),Fromvc.class); // Message from VC
               startActivity(intent);
           }
       });
       loc=(Button)findViewById(R.id.loc);
       loc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getApplication(),Details.class); // Location of SU
               startActivity(intent);
           }
       });
       ant=(Button)findViewById(R.id.ant);
       ant.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getApplication(),AntiRagging.class); // Antiragging
               startActivity(intent);
           }
       });
       CAL=(Button)findViewById(R.id.CAL);
       CAL.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getApplication(),Wall.class);

            startActivity(intent);           }
       });
       con=(Button)findViewById(R.id.con);
       con.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getApplication(),Contact1.class);

               startActivity(intent);

           }
       });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "WELCOME   PRITAM SHAH....", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            Exit();
            return true;
        }
        if(id==R.id.feed)
        {

            String uriText =
                    "mailto:"+"developerapphelp@gmail.com"+
                            "?subject=" + Uri.encode("test subject");
            Uri uri= Uri.parse(uriText);

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);

            Intent i = Intent.createChooser(emailIntent, "Send email to the developer...");
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(i);
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
            startActivity(intent);
        }
            else if (id == R.id.pron) {
                Intent intent=new Intent(getApplicationContext(),Pronounce.class);
                startActivity(intent);

        } else if (id == R.id.gallery) {
            Intent intent=new Intent(getApplicationContext(),SU_Live.class);
            startActivity(intent);


        }
        else if (id == R.id.contact) {
            Intent intent = new Intent(getApplicationContext(), ContactList.class);
            startActivity(intent);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
