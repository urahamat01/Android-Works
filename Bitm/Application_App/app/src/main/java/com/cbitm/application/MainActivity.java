package com.cbitm.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextId;
    private Button buttonId;
    private String phonenumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextId = findViewById(R.id.editTextId);
        buttonId = findViewById(R.id.buttonId);


        buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumer = editTextId.getText().toString().intern();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setAction(Intent.ACTION_SCREEN_ON);
                startActivity(intent);


//                String url=editText.getText().toString();
//                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                startActivity(intent);


            }
        });
    }
}
