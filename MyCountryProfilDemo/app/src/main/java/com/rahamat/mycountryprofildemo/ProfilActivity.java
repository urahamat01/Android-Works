package com.rahamat.mycountryprofildemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        imageView = findViewById(R.id.imageViewId);
        textView = findViewById(R.id.textViewId);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String countryName = bundle.getString("name");
            showDetails(countryName);
        }
    }

    void showDetails(String countryName) {

        if (countryName.equals("bangladesh")) {
            imageView.setImageResource(R.drawable.bangladesh);
            textView.setText(R.string.banglasesh_text);
        }

        if (countryName.equals("india")) {
            imageView.setImageResource(R.drawable.india);
            textView.setText(R.string.india_text);
        }

        if (countryName.equals("usa")) {
            imageView.setImageResource(R.drawable.usa);
            textView.setText(R.string.usa_text);
        }

    }
}
