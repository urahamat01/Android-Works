package com.alamin.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private EditText fistNameEt, lastNameEt, passwordEt, emailEt;
    private AutoCompleteTextView bloogGroupACTV;
    private Button signUpBtn;
    private String [] bloogGroup=  {"A+", "A-","B+", "B-","O+", "O-","AB+", "AB-"};
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        init();
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, bloogGroup);
        bloogGroupACTV.setAdapter(adapter);
        bloogGroupACTV.setThreshold(1);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean State) {
                if( State == true){
                    signUpBtn.setVisibility(View.VISIBLE);

                    signUpBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String fName = fistNameEt.getText().toString();
                            String lName = lastNameEt.getText().toString();
                            String password = passwordEt.getText().toString();
                            String email = passwordEt.getText().toString();

                            if (fName.isEmpty() || lName.isEmpty() || password.isEmpty() || email.isEmpty()){
                                Toast.makeText(MainActivity.this, "Input Correctly", Toast.LENGTH_LONG).show();
                            }
                        }
                    });



                }else {
                    signUpBtn.setVisibility(View.GONE);
                }
            }
        });


    }

    private void init() {

        fistNameEt = findViewById(R.id.firstNameEt);
        lastNameEt = findViewById(R.id.lastNameEt);
        passwordEt = findViewById(R.id.passwordEt);
        emailEt =findViewById(R.id.emailEt);
        bloogGroupACTV = findViewById(R.id.autoCompleteACTV);
        signUpBtn = findViewById(R.id.signUpBtn);
        checkBox = findViewById(R.id.checkBox);
    }
}
