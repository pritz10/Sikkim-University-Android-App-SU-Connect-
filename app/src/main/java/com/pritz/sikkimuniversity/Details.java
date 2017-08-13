package com.pritz.sikkimuniversity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Details extends AppCompatActivity {
    private WebView webView;

Button p;
    int a=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SU-MAP");
        webView = (WebView) findViewById(R.id.webview);

        //  progressBar = (ProgressBar) findViewById(R.id.progressBar);
        webView.setWebViewClient(new Details.myWebClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);

        // webView.loadUrl("http://www.cus.ac.in/images/contents/Sta/artImg/master.jpg");
        webView.loadDataWithBaseURL("file:///android_asset/", "<img src='map1.jpg' />", "text/html", "utf-8", null);
        p=( Button)findViewById(R.id.mp);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (a==1) {
                webView.loadDataWithBaseURL("file:///android_asset/", "<img src='map3.jpg' />", "text/html", "utf-8", null);
            a++;
                p.setText("White Theme");
            }
            else
            {
                webView.loadDataWithBaseURL("file:///android_asset/", "<img src='map1.jpg' />", "text/html", "utf-8", null);
            a=1;
                p.setText("Black Theme");
            }

            }
        });

    }

    public class myWebClient extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            setContentView(R.layout.nointernet);
            Toast.makeText(getApplicationContext(), "NO INTERNET\t!\nCheck Your Internet Connection... " + description, Toast.LENGTH_SHORT).show();
            //super.onReceivedError(view, errorCode, description, failingUrl);
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);


        }
    }
}


