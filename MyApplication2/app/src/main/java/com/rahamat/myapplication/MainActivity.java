package com.rahamat.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText phoneEt;
    private Button buttonBtn;
    private String phoneno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

        buttonBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                phoneno= phoneEt.getText().toString().trim();
                callAction();
            }
        });

    }

    private void callAction() {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" +phoneno));
        startActivity(intent);

    }

    private void init() {

        phoneEt = findViewById(R.id.phoneEt);
        buttonBtn = findViewById(R.id.buttonBtn);
    }
}
