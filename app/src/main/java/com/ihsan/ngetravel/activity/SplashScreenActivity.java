package com.ihsan.ngetravel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ihsan.ngetravel.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread timer = new Thread(){
            public void run() {
                try {
                    sleep(1500);
                } catch (Exception er) {
                    er.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreenActivity.this, FirstPageActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}