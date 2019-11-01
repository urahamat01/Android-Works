package com.mdrahamat.emailauthentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private TextView title;
    private EditText name, email, password;
    private Button singUpBtn;

    private String mname, memail, mpassword;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        singUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mname = name.getText().toString().trim();
                memail = email.getText().toString().trim();
                mpassword = password.getText().toString().trim();

                sendData(mname, memail, mpassword);
            }
        });

    }

    private void sendData(final String mname, final String memail, String mpassword) {
        firebaseAuth.createUserWithEmailAndPassword(memail, mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String userId = firebaseAuth.getCurrentUser().getUid();
                    DatabaseReference databaseRef = databaseReference.child("users").child(userId);
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("name", mname);
                    hashMap.put("email", memail);
                    databaseRef.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(MainActivity.this, SingInActivity.class));
                            }else {
                                Toast.makeText(MainActivity.this, "Something is wrong ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(MainActivity.this, "No data Insert Data ", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


    private void init() {
        title = findViewById(R.id.titleTextId);
        name = findViewById(R.id.nameEtId);
        email = findViewById(R.id.emailEtId);
        password = findViewById(R.id.passwordEtId);
        singUpBtn = findViewById(R.id.singUpBtnId);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public void singIn(View view) {
        startActivity(new Intent(MainActivity.this, SingInActivity.class));
    }
}
