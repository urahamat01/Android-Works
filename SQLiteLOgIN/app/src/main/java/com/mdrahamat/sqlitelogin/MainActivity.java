package com.mdrahamat.sqlitelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyDatabase myDatabase;

    private Button singInBtn, singUpBtn;
    private EditText userNameEt, passwordEt;
    private String username, password;
    //vedio 35


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        singInBtn.setOnClickListener(this);
        singUpBtn.setOnClickListener(this);
        myDatabase = new MyDatabase(this);
        SQLiteDatabase sqLiteDatabase = myDatabase.getWritableDatabase();
    }

    private void init() {
        singInBtn = findViewById(R.id.singInBtn1Id);
        singUpBtn = findViewById(R.id.singupBtn1Id);
        userNameEt = findViewById(R.id.usernameSingInETID);
        passwordEt = findViewById(R.id.passwordSingInETID);
    }

    @Override
    public void onClick(View v) {

        username = userNameEt.getText().toString().trim();
        password = passwordEt.getText().toString().trim();

        if (v.getId() == R.id.singInBtn1Id) {
            Intent intent = new Intent();
        } else if (v.getId() == R.id.singupBtn1Id) {
            Intent intent = new Intent(MainActivity.this, SingUpActivity.class);
            startActivity(intent);
        }

    }
}
