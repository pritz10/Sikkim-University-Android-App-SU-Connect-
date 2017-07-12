package com.pritz.sikkimuniversity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Aboout_App extends AppCompatActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboout__app);
b=(Button) findViewById(R.id.button5);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaddev();
            }
        });

    }
    void loaddev()

{
    String uriText =
            "mailto:"+"developerapphelp@gmail.com"+
                    "?subject=" + Uri.encode("Logging in Problem..");
    Uri uri= Uri.parse(uriText);

    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);

    Intent i = Intent.createChooser(emailIntent, "Send email to the developer...");
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

    startActivity(i);
}
}
