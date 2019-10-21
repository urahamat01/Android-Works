package com.mdrahamat.mylogodesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //logo Design manually
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);
        //getSupportActionBar().setLogo(R.drawable.ic_lock_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }
}
