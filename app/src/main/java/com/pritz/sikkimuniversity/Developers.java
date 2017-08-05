package com.pritz.sikkimuniversity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Developers extends AppCompatActivity {
FloatingActionButton cal1_,cal2_,mail1_,mail2_,abt1_,abt2_;
    public static String FACEBOOK_URL = "https://www.facebook.com/pritam.shah.58";
    public static String FACEBOOK_PAGE_ID = "YourPageName";
    FloatingActionButton if1,if2;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        getSupportActionBar().setTitle("Developers");
        if1=(FloatingActionButton)findViewById(R.id.abt1);
        if2=(FloatingActionButton)findViewById(R.id.abt2);
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


    public   void call1(View view)
    {   String number="+913592251468";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+number));
        startActivity(intent);
    }
    public void mail1(View v)
    {
        String uriText =
                "mailto:"+"pritzzzzz101010@gmail.com"+
                        "?subject=" + Uri.encode("Guest having Problem..");
        Uri uri= Uri.parse(uriText);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);

        Intent i = Intent.createChooser(emailIntent, "Send email to the Pritam Shah...");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(i);
    }


    public   void call2(View view)
    {   String number="+913592251468";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+number));
        startActivity(intent);
    }
    public void mail2(View v)
    {
        String uriText =
                "mailto:"+"robingurung652@gmail.com"+
                        "?subject=" + Uri.encode("Guest having Problem..");
        Uri uri= Uri.parse(uriText);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);

        Intent i = Intent.createChooser(emailIntent, "Send email to the Robin Gurung...");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(i);
    }


}
