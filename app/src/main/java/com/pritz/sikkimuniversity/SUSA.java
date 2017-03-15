package com.pritz.sikkimuniversity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import static com.pritz.sikkimuniversity.R.id.webview;

public class SUSA extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_su);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        webView = (WebView) findViewById(webview);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.getSettings().setJavaScriptEnabled(true);


        webView.loadUrl("http://sikkimuniversitystudentsassociation.in/");


    }
}
