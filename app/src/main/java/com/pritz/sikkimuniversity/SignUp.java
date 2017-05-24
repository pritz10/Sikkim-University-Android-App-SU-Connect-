package com.pritz.sikkimuniversity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Alaeddin on 5/14/2017.
 */

public class SignUp extends Activity {
        DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void SignUp(View v){
        if(v.getId()==R.id.btnSignUp){

            EditText ET_Name=(EditText) findViewById(R.id.ET_Name);
            EditText ET_Email=(EditText) findViewById(R.id.ET_Email);
            EditText ET_UserName=(EditText) findViewById(R.id.ET_UserName);
            EditText ET_Password=(EditText) findViewById(R.id.ET_Password);
            EditText ET_ConfirmPassword=(EditText) findViewById(R.id.ET_ConfirmPassword);

            String NameStr=ET_Name.getText().toString();
            String EmailStr=ET_Email.getText().toString();
            String UserNameStr=ET_UserName.getText().toString();
            String PasswordStr=ET_Password.getText().toString();
            String ConfirmPasswordStr=ET_ConfirmPassword.getText().toString();
            if(PasswordStr.equals(null))
            {
                Toast.makeText(this, "Should not be Null", Toast.LENGTH_SHORT).show();
            }

            if(!PasswordStr.equals(ConfirmPasswordStr)){
                Toast.makeText(this, "Passwords dont match", Toast.LENGTH_SHORT).show();
            }else {
                //Insert info to Database
                Contact contact=new Contact();
                contact.SetName(NameStr);
                contact.SetEmail(EmailStr);
                contact.SetUserName(UserNameStr);
                contact.SetPassword(PasswordStr);
                helper.InsertContacts(contact);

                Intent loginIntent=new Intent(this,DisplayData.class);
                //Send Data
                loginIntent.putExtra("UserName",UserNameStr);
                loginIntent.putExtra("Password",PasswordStr);

                startActivity(loginIntent);

            }

        }
    }

}
