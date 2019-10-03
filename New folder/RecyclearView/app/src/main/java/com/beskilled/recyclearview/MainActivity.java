package com.beskilled.recyclearview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private List<Student> studentList;
   private RecyclerView recyclerView;
   private StudentAddapter addapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclearVeiw);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addapter = new StudentAddapter(studentList);
        recyclerView.setAdapter(addapter);


        studentList.add(new Student("Shorna", 9206, "01521166984", "shorna5@gmail.com", R.drawable.shorna));
        studentList.add(new Student("Lima", 858, "0174539536", "lima@gmail.com", R.drawable.lima));
        studentList.add(new Student("Shorna", 9206, "01521166984", "shorna5@gmail.com", R.drawable.shorna));
        studentList.add(new Student("Lima", 858, "0174539536", "lima@gmail.com", R.drawable.lima));
        studentList.add(new Student("Shorna", 9206, "01521166984", "shorna5@gmail.com", R.drawable.shorna));
        studentList.add(new Student("Lima", 858, "0174539536", "lima@gmail.com", R.drawable.lima));
        studentList.add(new Student("Shorna", 9206, "01521166984", "shorna5@gmail.com", R.drawable.shorna));
        studentList.add(new Student("Lima", 858, "0174539536", "lima@gmail.com", R.drawable.lima));
        studentList.add(new Student("Shorna", 9206, "01521166984", "shorna5@gmail.com", R.drawable.shorna));
        studentList.add(new Student("Lima", 858, "0174539536", "lima@gmail.com", R.drawable.lima));
        studentList.add(new Student("Shorna", 9206, "01521166984", "shorna5@gmail.com", R.drawable.shorna));
        studentList.add(new Student("Lima", 858, "0174539536", "lima@gmail.com", R.drawable.lima));
        studentList.add(new Student("Shorna", 9206, "01521166984", "shorna5@gmail.com", R.drawable.shorna));
        studentList.add(new Student("Lima", 858, "0174539536", "lima@gmail.com", R.drawable.lima));
        addapter.notifyDataSetChanged();


    }
}
