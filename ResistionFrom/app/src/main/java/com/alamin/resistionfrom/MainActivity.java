package com.alamin.resistionfrom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameET, lastNameET, emailET, passwordET;

    private AutoCompleteTextView radioButtonACTV;
    private CheckBox checkboxBT;
    private Button buttonSU;
    private String[] bloadgroup = {"A+", "A-", "B+", "B-", "AB+", "AB-"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, bloadgroup);
        radioButtonACTV.setAdapter(adapter);
        radioButtonACTV.setThreshold(1);

        checkboxBT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {

                }
            }
        });

    }

    private void init() {
        firstNameET = findViewById(R.id.firstNameET);
        lastNameET = findViewById(R.id.lastNameET);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        radioButtonACTV = findViewById(R.id.radioButtonACTV);
        checkboxBT = findViewById(R.id.checkboxBT);
        buttonSU = findViewById(R.id.buttonSU);


    }
}
