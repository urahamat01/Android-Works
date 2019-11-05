package com.mdrahamat.loginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText singInEmailEditText, singInPasswordEditText;
    private TextView showTextView;
    private Button singInButton;
    private ProgressBar progressBar;
    private static final String TAG = "MainActivity";
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.setTitle("Sing In Pages ");
        singInButton.setOnClickListener(this);
        showTextView.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void init() {
        singInEmailEditText = findViewById(R.id.singInEmailEditTextId);
        singInPasswordEditText = findViewById(R.id.singInPasswordEditTextId);
        singInButton = findViewById(R.id.buttonSinId);
        showTextView = findViewById(R.id.textViewId);
        progressBar = findViewById(R.id.progressBerId);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSinId:

                userLogin();

                break;


            case R.id.textViewId:
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userLogin() {
        String email = singInEmailEditText.getText().toString().trim();
        String password = singInPasswordEditText.getText().toString().trim();
        Log.d(TAG, "userRegister: user register string");

        //validate Edit text
        if (email.isEmpty()) {
            Log.d(TAG, "userRegister: email valid");
            singInEmailEditText.setError("Entered your email id");
            singInEmailEditText.requestFocus();
            return;
        }

        //entered your valid email address

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Log.d(TAG, "userRegister: email address chech");
            singInEmailEditText.setError("Entered your valid Email address ");
            singInEmailEditText.requestFocus();
            return;
        }

        //check valid password and email
        if (password.isEmpty()) {
            Log.d(TAG, "userRegister: password check");
            singInPasswordEditText.setError("Enter Your valid email/password");
            singInPasswordEditText.requestFocus();
            return;
        }
        if (password.length() < 6) {
            Log.d(TAG, "userRegister: password length check");
            singInPasswordEditText.setError("Minimu password 4 fild");
            singInPasswordEditText.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Unsuccessfully", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
