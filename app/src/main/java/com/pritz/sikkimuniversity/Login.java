package com.pritz.sikkimuniversity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
 EditText regis1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login...");
        regis1=(EditText)findViewById(R.id.regis);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String registration_number=regis1.getText().toString().trim();
                String method="Login";
                Backgroundtask backgroundtask= new Backgroundtask(getApplicationContext());
                backgroundtask.execute(method,registration_number);

            }
        });
    }
}
