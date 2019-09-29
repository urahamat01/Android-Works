package com.cbitm.fragmentactivieylocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nameId, emailId;
    private Button buttonId;
    private String neme, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameId = findViewById(R.id.nameId);
        emailId = findViewById(R.id.emailId);
        buttonId = findViewById(R.id.buttonId);


        buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                neme = nameId.getText().toString();
                email = emailId.getText().toString();

                if (neme.equals("rahamat@gmail.com") && email.equals("1234")) {

                    Intent intent = new Intent(MainActivity.this, login_activity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }


            }
        });


    }
}
