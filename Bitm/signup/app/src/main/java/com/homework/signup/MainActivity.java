package com.homework.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText firstnameEt, lastnameEt, emailEt, passwordEt;
    private AutoCompleteTextView bloodgroupACTV;
    private CheckBox conditionCB;
    private Button signupButton;
    private String [] bloodgroup = {"AB+","AB-", "B+","B-" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(0);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item);
        bloodgroupACTV.setAdapter(adapter);
        bloodgroupACTV.setThreshold(1);

        conditionCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                if(check == true){
                    signupButton.setVisibility(View.VISIBLE);
                }
                else{
                    signupButton.setVisibility(View.GONE);
                }
            }
        });

    }

    private void init(int i) {
        firstnameEt = findViewById(R.id.firstnameEt);
        lastnameEt = findViewById(R.id.lastnameEt);
        emailEt = findViewById(R.id.emailEt);
        passwordEt= findViewById(R.id.passwordEt);
        bloodgroup = findViewById(R.id.bloodgroupACTV);
        conditionCB = findViewById(R.id.conditionCB);
        signupButton = findViewById(R.id.signupButton);
    }




}
