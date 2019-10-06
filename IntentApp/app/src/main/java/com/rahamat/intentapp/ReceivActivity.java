package com.rahamat.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceivActivity extends AppCompatActivity {
    private TextView textShow;
    private String show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiv);

        textShow = findViewById(R.id.textShowId);
        Intent intent = getIntent();
        show = intent.getStringExtra("sendKey");
        textShow.setText(show);
    }
}
