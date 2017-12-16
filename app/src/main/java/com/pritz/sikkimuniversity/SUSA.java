package com.pritz.sikkimuniversity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import static android.R.attr.description;
import static com.pritz.sikkimuniversity.R.id.webview;


public class SUSA extends AppCompatActivity {
    private WebView webView;
ProgressBar progressBar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
 getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        webView = (WebView) findViewById(R.id.webview);

        progressBar1=(ProgressBar)findViewById(R.id.progressBar);
        progressBar1.setVisibility(View.VISIBLE);
        WebSettings webSettings=webView.getSettings();
        webView.setWebViewClient(new myWebClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);


        webView.loadUrl("http://sikkimuniversitystudentsassociation.in/");
      //  webView.clearCache(true);
      //  webView.clearHistory();



       webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
     webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
       webView.getSettings().setAppCacheEnabled(true);
       webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);



       // webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
      //  webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }
        @Override
        public void onReceivedError (WebView view,
                                     WebResourceRequest request,
                                     WebResourceError error){
            setContentView(R.layout.nointernet);
            Toast.makeText(getApplicationContext(), "NO INTERNET\t!\nCheck Your Internet Connection... " + description, Toast.LENGTH_SHORT).show();
            //super.onReceivedError(view, errorCode, description, failingUrl);
        }
        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);

progressBar1.setVisibility(View.GONE);
        }
    }


   @Override
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
    }


    }
