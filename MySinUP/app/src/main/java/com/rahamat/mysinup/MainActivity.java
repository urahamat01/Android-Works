package com.rahamat.mysinup;

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
    private CheckBox checkBox;
    private String [] bloogGroup=  {"A+", "A-","B+", "B-","O+", "O-","AB+", "AB-"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init(0);

        //ArrayAdapter create
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, bloogGroup);
        bloogGroupACTV.setAdapter(adapter);
        //setThreshold create 1 count
        bloogGroupACTV.setThreshold(1);

        //checkBox create bisible and non bisible create

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {

                if( check == true){
                    signUpBtn.setVisibility(View.VISIBLE);

                    signUpBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            callButton();

                        }

                    });



                }else {

                    signUpBtn.setVisibility(View.GONE);

                }
            }
        });


    }

    private void callButton() {
        String fName = fistNameEt.getText().toString().trim();
        String lName = lastNameEt.getText().toString().trim();
        String password = passwordEt.getText().toString().trim();
        String email = emailEt.getText().toString().trim();
        String checkbox = checkBox.getText().toString().trim();
        String bloodGroupACTV = bloogGroupACTV.getText().toString().trim();
        if (fName.isEmpty()){
            Toast.makeText(this, "filap name", Toast.LENGTH_SHORT).show();
        } else if (lName.isEmpty()){
            Toast.makeText(this, "filap last name", Toast.LENGTH_SHORT).show();
        }else if (email.isEmpty()){
            Toast.makeText(this, "filap email", Toast.LENGTH_SHORT).show();
        }else if (password.isEmpty()){
            Toast.makeText(this, "filap password", Toast.LENGTH_SHORT).show();
        }else if (bloogGroupACTV.isPopupShowing()){
            Toast.makeText(this, "filap bloodGroup", Toast.LENGTH_SHORT).show();
        } else if (checkbox.isEmpty()){
            Toast.makeText(this, "filap checkbox", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
        }

//        if (fName.isEmpty() || lName.isEmpty() || password.isEmpty() || email.isEmpty()){
//            Toast.makeText(MainActivity.this, "Input Correctly", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(MainActivity.this, "Correctly Complete", Toast.LENGTH_SHORT).show();
//        }
    }

    private void init(int i) {

        fistNameEt = findViewById(R.id.firstnameEt);
        lastNameEt = findViewById(R.id.lastnameEt);
        passwordEt = findViewById(R.id.passwordEt);
        emailEt =findViewById(R.id.emailEt);
        bloogGroupACTV = findViewById(R.id.bloodgroupACTV);
        signUpBtn = findViewById(R.id.signupButton);
        checkBox = findViewById(R.id.conditionCB);
    }
}
