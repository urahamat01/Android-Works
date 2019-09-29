package com.rahamat.testmega;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    private Button button1, button2;

    private LinearLayout player1, player2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.card3);
        button2 = findViewById(R.id.card4);
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.addView(player1);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.addView(player2);

            }
        });
    }
}
