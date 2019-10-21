package com.mdrahamat.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameEt, ageEt;
    private Button insertBtn;
    private DatabaseHelper helper;
    private String name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        insertData();

    }


    private void insertData() {

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = nameEt.getText().toString().trim();
                age = ageEt.getText().toString().trim();

                long id = helper.insertData(name,age);
                Toast.makeText(MainActivity.this, "Your Id "+id, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void init() {

        nameEt = findViewById(R.id.nameId);
        ageEt = findViewById(R.id.ageId);
        insertBtn = findViewById(R.id.buttonId);
        helper = new DatabaseHelper(this);
    }

    public void showData(View view) {

        startActivity(new Intent(this,ShowActivity.class));
    }


}


