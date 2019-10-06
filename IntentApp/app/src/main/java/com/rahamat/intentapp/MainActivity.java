package com.rahamat.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button sendData;
    private String send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextId);
        sendData = findViewById(R.id.buttonId);
        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send = editText.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, ReceivActivity.class);
                intent.putExtra("sendKey", send);
                startActivity(intent);

            }
        });
    }
}
