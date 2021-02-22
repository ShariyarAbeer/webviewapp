package com.example.webviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView mywebView;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mywebView=(WebView) findViewById(R.id.webview);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://www.fishbox.com.bd/");
        WebSettings webSettings=mywebView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);





    }
    @Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }else if(pressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            finish();


        }
        else{

            Toast.makeText(MainActivity.this, "Press Back again to Exit.", Toast.LENGTH_SHORT).show();

        }
        pressedTime = System.currentTimeMillis();

    }


   // private class MyBrowser extends WebViewClient {
    //    @Override
      //  public boolean shouldOverrideUrlLoading(WebView view, String url) {
       //     view.loadUrl(url);
        //    return true;
      //  }
    //}
}