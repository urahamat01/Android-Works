package com.rahamat.appprojectlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listViewId);

        final String[] countryName = getResources().getStringArray(R.array.country_name);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.sample_view_country, R.id.textViewId, countryName);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = countryName[position];
                Toast.makeText(MainActivity.this, value+"  "+position, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
