package com.rahamat.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name, password;
    private Button sendBtn, loadBtn;
    private TextView showName, showPassword;
    private String nam, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nam = name.getText().toString().trim();
                pass = password.getText().toString().trim();
                sharePreferenceMeth();
                Toast.makeText(MainActivity.this, "Data save Successfully", Toast.LENGTH_SHORT).show();

            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSharePreferceneMeth();

            }
        });
    }

    private void loadSharePreferceneMeth() {

        SharedPreferences sharedPreferences = getSharedPreferences("DataFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (sharedPreferences.contains("nameKey") && sharedPreferences.contains("passKey")) {
            showName.setText(sharedPreferences.getString("nameKey", "Data Not Found"));
            showPassword.setText(sharedPreferences.getString("passKey", "Data Not Found"));


        } else {
            Toast.makeText(MainActivity.this, "Empty", Toast.LENGTH_SHORT).show();

        }

    }

    private void sharePreferenceMeth() {
        SharedPreferences sharedPreferences = getSharedPreferences("DataFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("nameKey", nam);
        editor.putString("passKey", pass);
        editor.commit();
    }

    private void init() {

        name = findViewById(R.id.editTextNameId);
        password = findViewById(R.id.editTextPassId);
        sendBtn = findViewById(R.id.sendBtn);
        loadBtn = findViewById(R.id.loadBtn);
        showName = findViewById(R.id.textNameShow);
        showPassword = findViewById(R.id.textPassLoad);
    }
}
