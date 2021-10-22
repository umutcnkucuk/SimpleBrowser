package com.example.simplebrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        EditText txtAddress = findViewById(R.id.txtAddress);
        Button btnGo = findViewById(R.id.btnGo);

    if(getIntent() != null && getIntent().getData() != null){
        txtAddress.setText(getIntent().getData().toString());
        webView.loadUrl(getIntent().getData().toString());
    }

    
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("http://" + txtAddress.getText());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}