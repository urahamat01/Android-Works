package com.mdrahamat.emailauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SingInActivity extends AppCompatActivity {
    private TextView title;
    private EditText email, password;
    private Button sinInBtn;
    private String semail, spassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        init();
    }

    @SuppressLint("WrongViewCast")
    private void init() {
        title = findViewById(R.id.stitleTextId);
        email = findViewById(R.id.semailEtId);
        password = findViewById(R.id.spasswordEtId);
        sinInBtn = findViewById(R.id.singInBtnId);
        firebaseAuth =FirebaseAuth.getInstance();
    }

    public void singUp(View view) {
        Intent intent = new Intent(SingInActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
