package com.pritz.sikkimuniversity;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;



public class help extends AppCompatActivity {
Button fb;
    Button aa1,bb,cc,dd,ee,ff,gg;
    String m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        aa1=(Button)findViewById(R.id.aa);
        bb=(Button)findViewById(R.id.bb);
        cc=(Button)findViewById(R.id.cc);
        dd=(Button)findViewById(R.id.dd);
        ee=(Button)findViewById(R.id.ee);
        ff=(Button)findViewById(R.id.ff);
        gg=(Button)findViewById(R.id.gg);
       fb=(Button)findViewById(R.id.fbc);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(help.this,Developers.class);
                startActivity(i);
            }
        });


    }

    public void happy(View v) {
        switch(v.getId())
        {
            case R.id.aa:m="Report a Bug!";
                main(m);
                break;
            case R.id.bb:m="Suggest Something new";
                main(m);
                break;
            case R.id.cc:m="Improve Existing Feature";
                main(m);
                break;
            case R.id.dd:m="Make us Laugh!";
                main(m);
                break;
            case R.id.ee:m="ma";
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                //builder.setTitle("Exit");
                builder.setMessage("For Marshmallow users." +
                        "\nYou have to give permission to this app by selecting app info and navigating to permission in settings.You have to give permission for accessing 'Contact','Camera','Gallery','Storage'. Otherwise the app will not work smoothly if the permissions are not provided." +
                        "Thank You ");
                builder.setPositiveButton("Okay",null);
                ;
                builder.create();
                builder.show();
                break;
            case R.id.ff:m="Any Others";
                main(m);
                break;


        }}

    void main(String m)
    {
        String uriText =
                "mailto:"+"developerapphelp@gmail.com"+
                        "?subject=" + Uri.encode(m);
        Uri uri= Uri.parse(uriText);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);

        Intent i = Intent.createChooser(emailIntent, "Send email to the developer...");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(i);
    }
}
