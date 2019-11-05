package com.mdrahamat.sqlitelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SingUpActivity extends AppCompatActivity {
    private EditText nameEt, emailEt, usernameEt, passwordEt;
    private Button singUpBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        init();
    }

    private void init() {
    }
}
