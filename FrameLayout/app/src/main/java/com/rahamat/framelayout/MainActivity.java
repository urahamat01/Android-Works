package com.rahamat.framelayout;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.image1Id);
        imageView2 = findViewById(R.id.image2Id);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.image1Id) {
            imageView1.setVisibility(View.GONE);
            imageView2.setVisibility(View.VISIBLE);

        } else if (v.getId() == R.id.image2Id) {
            imageView2.setVisibility(View.GONE);
            imageView1.setVisibility(View.VISIBLE);

        }

    }
}
