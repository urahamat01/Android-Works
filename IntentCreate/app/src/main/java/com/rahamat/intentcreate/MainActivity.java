package com.rahamat.intentcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String email;
    private TextView welcomeTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        email = getIntent().getStringExtra("key");

        welcomeTV.setText("Welcome " + email);
    }

    private void init() {
        welcomeTV = findViewById(R.id.welcomeTV);
    }
}
