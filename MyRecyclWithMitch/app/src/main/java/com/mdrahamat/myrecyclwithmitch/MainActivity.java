package com.mdrahamat.myrecyclwithmitch;

import androidx.appcompat.app.AppCompatActivity;

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

                name = nameEt.getText().toString();
                age = ageEt.getText().toString();

                long id = helper.insertData(name,age);
                Toast.makeText(MainActivity.this, " Your Id "+id, Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void init() {

        nameEt = findViewById(R.id.nameET);
        ageEt = findViewById(R.id.ageET);
        insertBtn = findViewById(R.id.insertBtn);
        helper = new DatabaseHelper(this);

    }
}

