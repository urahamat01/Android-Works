package com.mdrahamat.firebaseauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText phoneNoET;
    private Button nextBtn;
    private String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNo = phoneNoET.getText().toString().trim();
                if (phoneNo.length()==11){
                    Intent intent = new Intent(LoginActivity.this,VerifyActivity.class);
                    intent.putExtra("key",phoneNo);
                    startActivity(intent);

                }else {
                    Toast.makeText(LoginActivity.this, "Error Number not match"+phoneNo, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        phoneNoET = findViewById(R.id.phoneNoEt);
        nextBtn = findViewById(R.id.nextBtnn);
    }
}
