package com.mdrahamat.myfirebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameET, ageET;
    private Button saveBTN;
    private String name, age;
    private DatabaseReference databaseRef;
    private Button loadDataBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseRef = FirebaseDatabase.getInstance().getReference("students");
        init();
        saveBTN.setOnClickListener(this);
        loadDataBTN.setOnClickListener(this);

    }

    private void init() {
        nameET = findViewById(R.id.nameEditId);
        ageET = findViewById(R.id.ageEditId);
        saveBTN = findViewById(R.id.saveDataId);
        loadDataBTN = findViewById(R.id.loadDataId);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.saveDataId) {
            saveData();
        } else if (v.getId() == R.id.loadDataId) {
            loadData();

        }

    }

    private void loadData() {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        startActivity(intent);
    }

    private void saveData() {

        name = nameET.getText().toString().trim();
        age = ageET.getText().toString().trim();

        String key = databaseRef.push().getKey();
        Student student = new Student(name, age);

        databaseRef.child(key).setValue(student).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Not Data entity", Toast.LENGTH_SHORT).show();
                }
                nameET.setText("");
                ageET.setText("");
            }
        });
        Toast.makeText(this, " Studnet information is added ", Toast.LENGTH_SHORT).show();

    }
}
