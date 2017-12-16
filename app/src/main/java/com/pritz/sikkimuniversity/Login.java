package com.pritz.sikkimuniversity;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class Login extends AppCompatActivity {
    // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds

    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;
    private EditText etEmail;
    TextToSpeech t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getSupportActionBar().setTitle("Enter Your Registration Number");
        getSupportActionBar().hide();
        // Get Reference to variables
        etEmail = (EditText) findViewById(R.id.email);



        File file = new File("/data/data/com.pritz.sikkimuniversity/shared_prefs/userinfo.xml");
        if (file.exists()) {
            /*final ProgressDialog progressBar = new ProgressDialog(Login.this);
            progressBar.setCancelable(true);
            progressBar.setMessage("Getting Refreshed...");
            progressBar.show();
            long delayInMillis = 5000;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    progressBar.dismiss();
                }
            }, delayInMillis);*/

                    startActivity(new Intent(Login.this, MainActivity.class));
            Login.this.finish();
        }
    }


    public void aboutapp(View av) {
        Intent intent = new Intent(Login.this, Aboout_App.class);
        startActivity(intent);
    }
    public void guestmode(View v) {
        Intent intent = new Intent(Login.this, GuestMode.class);
        startActivity(intent);
    }

    // Triggers when LOGIN Button clicked
    public void checkLogin(View arg0) {

        // Get text from email and passord field
        final String email = etEmail.getText().toString().toUpperCase();
        if (TextUtils.isEmpty(email)) {
            Snackbar.make(arg0, "Enter your Registration Number !", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            //etEmail.setError("Registration Number empty !");
        }

        // Initialize  AsyncLogin() class with email and password
        else {
            new AsyncLogin().execute(email);
        }


    }

    public void pl(View v) {
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }

    private class AsyncLogin extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(Login.this);
        HttpURLConnection conn;

        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if(status != TextToSpeech.ERROR) {
                        t1.setLanguage(Locale.UK);
                    }
                }
            });

            //this method will be running on UI thread
            pdLoading.setMessage("\tBreathe in Breathe out...");
            pdLoading.setCancelable(false);
            pdLoading.show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your php file resides
                url = new URL("http://developerapphelp.000webhostapp.com/login.php");

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "exception";
            }
            try {
                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");

                // setDoInput and setDoOutput method depict handling of both send and receive
                conn.setDoInput(true);
                conn.setDoOutput(true);

                // Append parameters to URL
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("username", params[0]);
                String query = builder.build().getEncodedQuery();

                // Open connection for sending data
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return "exception";
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "exception";
            } finally {
                conn.disconnect();
            }


        }




        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread


            pdLoading.dismiss();

            if (result.equals("1")) {
                Toast.makeText(Login.this, "Invalid Registration Number!", Toast.LENGTH_LONG).show();
            } else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")) {

                Toast.makeText(Login.this, "OOPs! Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();
            } else  //(result.equalsIgnoreCase("true"))
            {
                /* Here launching another activity when login successful. If you persist login state
                use sharedPreferences of Android. and logout button to clear sharedPreferences.
                 */
               Toast toast=Toast.makeText(Login.this, "\nWELCOME to Sikkim University Android App \n" + result.toUpperCase()+"\n", Toast.LENGTH_LONG);
                toast.show();
                toast.setGravity(Gravity.TOP, 0, 0);


                //  Intent loginIntent = new Intent(Login.this,MainActivity.class);
                //Send Data
                // loginIntent.putExtra("UserName",result);// this is where you put extras
                // loginIntent.putExtra("Password",PasswordStr);// this too..... commented by rob

                SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("s_name", result);
                t1.speak("Welcome to Sikkim University Android App  ,"+result+"\nHave A Nice Day ahead", TextToSpeech.QUEUE_FLUSH, null);
                //adapter.notifyDataSetChanged();


                //editor.putString("s_dept",Department);

                editor.apply();
                startActivity(new Intent(Login.this, MainActivity.class));


                //startActivity(loginIntent);
                 Login.this.finish();

            }/*else if (result.equalsIgnoreCase("false")){

                // If username and password does not match display a error message
                Toast.makeText(Login.this, "Invalid email or password", Toast.LENGTH_LONG).show();

            }*/
        }

    }
}