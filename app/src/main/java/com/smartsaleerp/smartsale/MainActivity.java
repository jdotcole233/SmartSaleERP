package com.smartsaleerp.smartsale;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler splashhandler = new Handler();
        Runnable splashrunnable = new Runnable() {
            @Override
            public void run() {
                Intent splashintent = new Intent(MainActivity.this, ValidateCredentials.class);
                startActivity(splashintent);
                finish();
            }
        };

        splashhandler.postDelayed(splashrunnable, 3000);

    }
}
