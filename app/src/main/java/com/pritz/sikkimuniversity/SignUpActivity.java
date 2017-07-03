package com.pritz.sikkimuniversity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    // Sign Up Page Views
    private EditText signUpEmail;
    private EditText signUpPassword;
    private EditText signUpPhone;
    private EditText signUpName;
    private Button buttonSignUp;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpEmail = (EditText) findViewById(R.id.editTextSignUpEmail);

        signUpPassword = (EditText) findViewById(R.id.editTextSignUpPassword);

        signUpPhone = (EditText) findViewById(R.id.editTextSignUpPhone);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void signUp() {
        String email = signUpEmail.getText().toString().trim();
        String password = signUpPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "No email given", Toast.LENGTH_SHORT).show();
            signUpEmail.setError("Email cannot be empty");
        }
        else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "No password given", Toast.LENGTH_SHORT).show();
            signUpPassword.setError("Password cannot be empty");
        }
        else if(password.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_LONG).show();
            signUpPassword.setError("Password must be at least 6 characters");
        }else{
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("One moment please");
            progressDialog.show();

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.hide();
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "You are registered!", Toast.LENGTH_SHORT).show();
                                //redirect to another page
                            } else {
                                Toast.makeText(SignUpActivity.this, "Could not register at this time", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    @Override
    public void onClick(View view) {
        if(view == buttonSignUp){
            signUp();
        }
    }
}
