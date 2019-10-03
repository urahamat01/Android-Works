package com.rahamat.basedadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] countryName;
    int[] flags = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);
        countryName = getResources().getStringArray(R.array.country_name);

        CustomAdapter adapter = new CustomAdapter(this, countryName, flags);
        listView.setAdapter(adapter);
    }
}
