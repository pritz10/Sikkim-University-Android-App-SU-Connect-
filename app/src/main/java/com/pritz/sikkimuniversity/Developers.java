package com.pritz.sikkimuniversity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Developers extends AppCompatActivity {
FloatingActionButton cal1_,cal2_,mail1_,mail2_,abt1_,abt2_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        getSupportActionBar().setTitle("Developers");



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
