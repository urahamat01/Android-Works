package com.rahamat.loginfrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginEmail extends AppCompatActivity {
    private EditText usernameId,emailId,passwordId;
    private Button buttonId;
    private  String username, emiail, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_email);

        init();
        buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //string convert
                username= usernameId.getText().toString().trim();
                emiail = emailId.getText().toString().trim();
                password = passwordId.toString().trim();

                //valid
                if (username.equals("rahamat") && password.equals("1234")){
                    Intent intent =new Intent(LoginEmail.this, MainActivity.class);
                    intent.putExtra("email",username);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginEmail.this, " Not Vlid Email and Password ", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }

    private void init() {

        usernameId = findViewById(R.id.usernameId);
        emailId = findViewById(R.id.emailId);
        passwordId = findViewById(R.id.emailId);
        buttonId = findViewById(R.id.buttonId);


    }
}
