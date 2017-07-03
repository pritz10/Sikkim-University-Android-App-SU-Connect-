package com.pritz.sikkimuniversity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AntiRagging extends AppCompatActivity {
    String number="18001805522";
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Antiragging");
        setContentView(R.layout.activity_anti_ragging);
        imageButton=(ImageButton)findViewById(R.id.imagebtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
               intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });
    }
}
