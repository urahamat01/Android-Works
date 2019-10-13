package com.rahamat.recyclerviewuse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private List<String> mImage = new ArrayList<>();
    private List<String> mImageNames = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecycleViewAdapter recycleViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        initImageBitmaps();

    }


    private void initImageBitmaps() {
        mImage.add("https://i.redd.it/glin0nwndo501.jpg");
        mImageNames.add("Rahamat Ullah");
        mImage.add("https://i.redd.it/glin0nwndo501.jpg");
        mImageNames.add("Rahamat Ullah");

        initRecycleView();
    }

    private void initRecycleView() {
        Log.d(TAG, "recycleView : init Recycleview");
        recyclerView = findViewById(R.id.recyclerViewId);
        recycleViewAdapter = new RecycleViewAdapter(this, mImage, mImageNames);
        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
