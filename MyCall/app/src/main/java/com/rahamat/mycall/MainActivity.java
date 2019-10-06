package com.rahamat.mycall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                phoneNo= editText.getText().toString().trim();
                callAction();
            }
        });
    }
    private void callAction() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel : "+ phoneNo));
        startActivity(intent);
    }

    private void init() {
        editText = findViewById(R.id.editTextId);
        button = findViewById(R.id.buttonId);
    }
}
