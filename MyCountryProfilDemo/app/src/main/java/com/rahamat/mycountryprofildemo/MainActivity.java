package com.rahamat.mycountryprofildemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bangladeshButton, indiaButton, usaButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bangladeshButton = findViewById(R.id.bangladeshButtonId);
        indiaButton = findViewById(R.id.indianButtonId);
        usaButton = findViewById(R.id.usaButtonId);


        bangladeshButton.setOnClickListener(this);
        indiaButton.setOnClickListener(this);
        usaButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.bangladeshButtonId) {
            intent = new Intent(MainActivity.this, ProfilActivity.class);
            intent.putExtra("name", "bangladesh");
            startActivity(intent);
        }


        if (v.getId() == R.id.indianButtonId) {
            intent = new Intent(MainActivity.this, ProfilActivity.class);
            intent.putExtra("name", "india");
            startActivity(intent);
        }


        if (v.getId() == R.id.usaButtonId) {
            intent = new Intent(MainActivity.this, ProfilActivity.class);
            intent.putExtra("name", "usa");
            startActivity(intent);
        }

    }
}
