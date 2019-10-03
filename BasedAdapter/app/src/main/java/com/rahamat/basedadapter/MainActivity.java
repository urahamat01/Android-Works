package com.rahamat.basedadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] countryName;
    int[] flags = {R.drawable.bangladesh, R.drawable.india,
            R.drawable.bangladesh, R.drawable.coratia,
            R.drawable.coratia, R.drawable.germany,
            R.drawable.india, R.drawable.sweden, R.drawable.tomas_arad_face,
            R.drawable.canada};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listViewId);
        countryName = getResources().getStringArray(R.array.country_name);


        CustomAdaptor adaptor = new CustomAdaptor(this, countryName, flags);
        listView.setAdapter(adaptor);


    }
}
