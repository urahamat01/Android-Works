package com.mdrahamat.googlemapsandgoogleplace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.ErrorDialogFragment;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.fido.u2f.api.common.ErrorResponseData;

import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final int ERROR_DIALOG_REQUEST = 9001;
    Button buttMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (isServiecesOk()) {
            init();
        }
    }

    private void init() {

        buttMap = findViewById(R.id.mapeBtnId);
        buttMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean isServiecesOk() {
        Log.d(TAG, "isServiecesOk: check googleServices Versions");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if (available == ConnectionResult.SUCCESS) {

            //EVERY thing ok map request is available
            Log.d(TAG, "isServiecesOk: google play services is working");

            return true;
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            //error occure is resoulb it
            Log.d(TAG, "isServiecesOk: error cod but it fixed it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();

        } else {
            Toast.makeText(this, "we can make requset", Toast.LENGTH_SHORT).show();
        }
        return false;

    }
}
