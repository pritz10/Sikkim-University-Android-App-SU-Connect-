package com.pritz.sikkimuniversity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
 import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;




public class Developers extends AppCompatActivity {
FloatingActionButton cal1_,cal2_,mail1_,mail2_,abt1_,abt2_;
    public static String FACEBOOK_URL = "https://www.facebook.com/pritam.shah.58";
    public static String FACEBOOK_PAGE_ID = "YourPageName";
    FloatingActionButton if1,if2,if3,aa,bb,aa1,bb1;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
//        getSupportActionBar().setTitle("Developers");
        if1=(FloatingActionButton)findViewById(R.id.abt1);
        if2=(FloatingActionButton)findViewById(R.id.abt2);
        if3=(FloatingActionButton)findViewById(R.id.abt3);
        aa=(FloatingActionButton)findViewById(R.id.cal1);
        aa1=(FloatingActionButton)findViewById(R.id.cal2);
        bb=(FloatingActionButton)findViewById(R.id.mail1);
        bb1=(FloatingActionButton)findViewById(R.id.mail2);

      aa.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {
            String number = "08906076058";

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }
        catch (Exception e) {
            //TODO smth
        }
    }
});
        aa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number="08348465526";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                String name = sharedPreferences.getString("s_name","");
                String uriText =
                        "mailto:"+"pritzzzzz101010@gmail.com"+
                                "?subject=" + Uri.encode("From\t"+name);
                Uri uri= Uri.parse(uriText);

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);

                Intent i = Intent.createChooser(emailIntent, "Send email to the Pritam Shah...");
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(i);
            }
        });
bb1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("s_name","");
        String uriText =
                "mailto:"+"robingurung652@gmail.com"+
                        "?subject=" + Uri.encode("From\t"+name);
        Uri uri= Uri.parse(uriText);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);

        Intent i = Intent.createChooser(emailIntent, "Send email to the Robin Gurung...");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(i);
    }
});

        if1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facebookIntent = openFacebook(Developers.this);
                startActivity(facebookIntent);

            }
        });
        if2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facebookIntent = openFacebook1(Developers.this);
                startActivity(facebookIntent);

            }
        });
        if3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facebookIntent = openFacebook3(Developers.this);
                startActivity(facebookIntent);

            }
        });

    }



    public static Intent openFacebook(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/100003128310014"));
        } catch (PackageManager.NameNotFoundException e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.facebook.com/pritam.shah.58"));
        }
    }

    public static Intent openFacebook1(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/100001511818200"));
        } catch (PackageManager.NameNotFoundException e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.facebook.com/robin.n.gurung"));
        }
    }
    public static Intent openFacebook3(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/100009361852497"));
        } catch (PackageManager.NameNotFoundException e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/profile.php?id=100009361852497"));
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.cl) {
            String number="07585910557";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+number));
            startActivity(intent);
        }
        if (id == R.id.ml) {
            SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            String name = sharedPreferences.getString("s_name","");
            String uriText =
                    "mailto:"+"developerapphelp@gmail.com"+
                            "?subject=" + Uri.encode("From\t"+name);
            Uri uri= Uri.parse(uriText);

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);

            Intent i = Intent.createChooser(emailIntent, "Send email to the Robin Gurung...");
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}
