package com.rahamat.intentcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEt, emailEt, passwordEt;
    private Button loginBtn;
    private String username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameEt.getText().toString().trim();
                email = emailEt.getText().toString().trim();
                password = passwordEt.getText().toString().trim();

                if (email.equals("urahamat@gmail.com") && password.equals("1234")) {

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("key", email);
                    startActivity(intent);
                }
            }

        });
    }

    private void init() {

        usernameEt = findViewById(R.id.usernameEt);
        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        loginBtn = findViewById(R.id.loginBtn);
    }
}
