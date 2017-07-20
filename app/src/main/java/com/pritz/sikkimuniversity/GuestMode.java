package com.pritz.sikkimuniversity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuestMode extends AppCompatActivity {
Button button4,button6,button7,button8,button9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_mode);
        getSupportActionBar().setTitle("Guest Mode");

    }
  public   void call(View view)
    {   String number="+913592251468";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+number));
        startActivity(intent);
    }
    public void mail(View v)
    {
        String uriText =
                "mailto:"+"developerapphelp@gmail.com"+
                        "?subject=" + Uri.encode("Guest having Problem..");
        Uri uri= Uri.parse(uriText);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);

        Intent i = Intent.createChooser(emailIntent, "Send email to the developer...");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(i);
    }
    public void loc(View g)
    {
        Intent i=new Intent(GuestMode.this,Details.class);
        startActivity(i);
    }
}
