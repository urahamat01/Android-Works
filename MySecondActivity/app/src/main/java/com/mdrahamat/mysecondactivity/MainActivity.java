package com.mdrahamat.mysecondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameEt, ageEt;
    private Button inButton1;
    private String name, age;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       init();
       insertData();
    }

    private void insertData() {

        inButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = nameEt.getText().toString().trim();
                age=ageEt.getText().toString().trim();
                long id = databaseHelper.insertData(name,age);

                Toast.makeText(MainActivity.this, "Toast Id"+id, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void init() {
        nameEt =findViewById(R.id.nameET);
        ageEt = findViewById(R.id.ageET);
        inButton1 = findViewById(R.id.insetButtonId);
        databaseHelper = new DatabaseHelper(this);
    }

    public void showDatas(View view) {

        startActivity(new Intent(this,ShowActivity.class));
    }
}
