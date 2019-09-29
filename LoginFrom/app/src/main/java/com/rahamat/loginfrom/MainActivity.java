package com.rahamat.loginfrom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewId);
        textView.setText("Email  "+email);
        email = getIntent().getStringExtra("Email  ");

       // email = getIntent().getStringExtra("email  ");
    }
}
