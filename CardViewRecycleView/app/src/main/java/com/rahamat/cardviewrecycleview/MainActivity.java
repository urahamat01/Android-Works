package com.rahamat.cardviewrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> cityNames;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //list create ArrayList
        cityNames = new ArrayList<>(Arrays.asList("Dhaka", "Barisal", "Khluna", "Rashai", "Khukata", "Rangpur", "Chandipur", "Chitigong", "Kustia", "Bugura"));


        recyclerView = findViewById(R.id.recycleViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapter = new CustomAdapter(this, cityNames);
        recyclerView.setAdapter(customAdapter);

    }
}
