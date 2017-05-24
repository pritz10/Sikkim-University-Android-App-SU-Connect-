package com.pritz.sikkimuniversity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityLogin extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        getSupportActionBar().setTitle("SignUp User");
    }

    public  void onBtnLoginInClick(View v){
        if(v.getId()==R.id.btnLoging){
            //Passing userName
            EditText UserNameET=(EditText) findViewById(R.id.ET_UserName);
            String UserNameStr=UserNameET.getText().toString();
            //Passing Password
            EditText PasswordET=(EditText)findViewById(R.id.ET_Password);
            String PasswordStr=PasswordET.getText().toString();


            String dbPassword=helper.LoginIn(UserNameStr);
            //Send UserName to Database to find it, and return Password
            //To compare it with Current Password from user input
            if(dbPassword.equals(PasswordStr)){
                Intent loginIntent=new Intent(this,DisplayData.class);
                //Send Data
                loginIntent.putExtra("UserName",UserNameStr);
                loginIntent.putExtra("Password",PasswordStr);

                startActivity(loginIntent); 
            }else {
                Toast.makeText(this, "UserName and Passwords dont match", Toast.LENGTH_SHORT).show();
            }

            
        }
    }

    public void onBtnSignUoClick(View v){
        if(v.getId()==R.id.btnSignUp){
            Intent SignUpIntent=new Intent(this,SignUp.class);
            startActivity(SignUpIntent);
        }
    }

}
