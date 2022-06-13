package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private String Base= "https://el-pipila.herokuapp.com";
    private WebView myWebView;
    ProgressBar myProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView)findViewById(R.id.activity_main_webview);
        myProgressBar= (ProgressBar)findViewById(R.id.ProgressBar);
        WebSettings webSettings = myWebView.getSettings();
        ((WebSettings) webSettings).setJavaScriptEnabled(true);
        myWebView.loadUrl(Base);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                myProgressBar.setProgress(0);
                myProgressBar.setVisibility(View.VISIBLE);
                myProgressBar.incrementProgressBy(newProgress);
                if (newProgress==100)
                {
                    myProgressBar.setVisibility(View.GONE);
                }
            }
        });
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setAllowFileAccess(true);
        myWebView.getSettings().setAllowFileAccess(true);

    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack())
        {
            myWebView.goBack();
        }else
        super.onBackPressed();
    }
}