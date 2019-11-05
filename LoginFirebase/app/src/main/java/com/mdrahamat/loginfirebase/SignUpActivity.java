package com.mdrahamat.loginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText singUpEmailEditText, singUpPasswordEditText;
    private TextView showSinUpTextView;
    private Button singUpButton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private static final String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sing Up Page");

        init();

        singUpButton.setOnClickListener(this);
        showSinUpTextView.setOnClickListener(this);
    }

    private void init() {
        singUpEmailEditText = findViewById(R.id.singUpEmailEditTextId);
        singUpPasswordEditText = findViewById(R.id.singUpPasswordEditTextId);
        showSinUpTextView = findViewById(R.id.textViewSupId);
        singUpButton = findViewById(R.id.buttonSupId);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBerId);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSupId:
                userRegister();
                break;

            case R.id.textViewSupId:

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userRegister() {
        String email = singUpEmailEditText.getText().toString().trim();
        String password = singUpPasswordEditText.getText().toString().trim();
        Log.d(TAG, "userRegister: user register string");

        //validate Edit text
        if (email.isEmpty()) {
            Log.d(TAG, "userRegister: email valid");
            singUpEmailEditText.setError("Entered your email id");
            singUpEmailEditText.requestFocus();
            return;
        }

        //entered your valid email address

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Log.d(TAG, "userRegister: email address chech");
            singUpEmailEditText.setError("Entered your valid Email address ");
            singUpEmailEditText.requestFocus();
            return;
        }

        //check valid password and email
        if (password.isEmpty()) {
            Log.d(TAG, "userRegister: password check");
            singUpPasswordEditText.setError("Enter Your valid email/password");
            singUpPasswordEditText.requestFocus();
            return;
        }
        if (password.length() < 6) {
            Log.d(TAG, "userRegister: password length check");
            singUpPasswordEditText.setError("Minimu password 4 fild");
            singUpPasswordEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Log.d(TAG, "onComplete:  task successfully check");

                    Toast.makeText(getApplicationContext(), "Register is successfully", Toast.LENGTH_SHORT).show();

                } else {

                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Log.d(TAG, "onComplete: task check");
                        Toast.makeText(getApplicationContext(), "Register is not successfully", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(getApplicationContext(), "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
}
