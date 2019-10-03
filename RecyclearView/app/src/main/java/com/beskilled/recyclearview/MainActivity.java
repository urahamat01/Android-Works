package com.beskilled.recyclearview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private List<Student> studentList;
   private RecyclerView recyclerView;
   private StudentAddapter addapter;
   private Button button;
   private EditText name, id, email;




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameId);
        id = findViewById(R.id.showId);
        email = findViewById(R.id.emailId);

        studentList = new ArrayList<>();
        button = findViewById(R.id.buttonInsertId);
        recyclerView = findViewById(R.id.recyclearVeiw);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addapter = new StudentAddapter(studentList);
        recyclerView.setAdapter(addapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name, id, email;



                recyclerView.setAdapter(addapter);
                addapter.getItemCount();

            }
        });






    }
}
