package com.rahamat.mysplashscreen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //Request tital remove
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notatification
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        progressBar = findViewById(R.id.progressBerId);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });
        thread.start();
    }

    private void startApp() {
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        // intent.setData();
        // intent.setAction();
        startActivity(intent);
        finish();
    }

    private void doWork() {
        for (progress = 10; progress <= 100; progress += 10) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
