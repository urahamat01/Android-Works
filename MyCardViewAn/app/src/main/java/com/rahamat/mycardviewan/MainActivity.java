package com.rahamat.mycardviewan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView schoolCardView, hospitalCardView, airportCardView, resturantCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set find viewById View Text

        schoolCardView = findViewById(R.id.schoolCardViewId);
        hospitalCardView = findViewById(R.id.hospitalCardViewId);
        airportCardView = findViewById(R.id.airportCardViewId);
        resturantCardView = findViewById(R.id.resturantCardViewId);

        //setClick Listuraner
        schoolCardView.setOnClickListener(this);
        hospitalCardView.setOnClickListener(this);
        airportCardView.setOnClickListener(this);
        resturantCardView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.schoolCardViewId) {
            Intent intent = new Intent(MainActivity.this, schoolActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.hospitalCardViewId) {

            Intent intent = new Intent(MainActivity.this, hospitalActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.airportCardViewId) {
            Intent intent = new Intent(MainActivity.this, airportActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.resturantCardViewId) {
            Intent intent = new Intent(MainActivity.this, resturantActivity.class);
            startActivity(intent);


        }

    }
}
