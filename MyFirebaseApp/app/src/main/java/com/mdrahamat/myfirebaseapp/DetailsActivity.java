package com.mdrahamat.myfirebaseapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailsActivity";

    private List<Student> studentList;
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private DatabaseReference databaseReference;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Log.d(TAG, "onCreate: onCreate Start");
        init();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        databaseReference = FirebaseDatabase.getInstance().getReference("students");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {

                    Student student = data.getValue(Student.class);
                    studentList.add(student);
                }

                studentAdapter = new StudentAdapter(studentList);
                recyclerView.setAdapter(studentAdapter);
                progressBar.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DetailsActivity.this, "Data is error", Toast.LENGTH_SHORT).show();

                progressBar.setVisibility(View.INVISIBLE);
            }
        });


    }

/*    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: onStart Create");

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d(TAG, "onDataChange: onDataChange Used");

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Log.d(TAG, "onDataChange: for loop");
                    Student student = data.getValue(Student.class);
                    studentList.add(student);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }*/

    private void init() {
        studentList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);
        progressBar = findViewById(R.id.progressBarId);

    }
}
