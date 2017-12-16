package com.pritz.sikkimuniversity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import static com.pritz.sikkimuniversity.R.id.webview;

public class Wall extends AppCompatActivity {

    private WebView webView;
    //  ProgressBar progressBar;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Academic Calendar");
        webView = (WebView) findViewById(R.id.webview);
        progressDialog=new ProgressDialog(this);
        //  progressBar = (ProgressBar) findViewById(R.id.progressBar);
        webView.setWebViewClient(new myWebClient());
        WebSettings webSettings=webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);

        webView.getSettings().setBuiltInZoomControls(true);
        progressDialog.setMessage("Have a Good day...");
        progressDialog.show();
        // webView.loadUrl("http://www.cus.ac.in/images/contents/Sta/artImg/master.jpg");
        webView.loadDataWithBaseURL("file:///android_asset/", "<img src='cal.PNG' />", "text/html", "utf-8", null);

    }

    public class myWebClient extends WebViewClient
    {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }
        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            setContentView(R.layout.nointernet);
            Toast.makeText(getApplicationContext(),  "NO INTERNET\t!\nCheck Your Internet Connection... "+ description, Toast.LENGTH_SHORT).show();
            //super.onReceivedError(view, errorCode, description, failingUrl);
        }
        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);

            progressDialog.dismiss();

        }


    }



  /*  @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        else
        {
            finish();
            return true;
        }
    }*/
}

