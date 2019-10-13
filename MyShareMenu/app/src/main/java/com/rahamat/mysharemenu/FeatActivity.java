package com.rahamat.mysharemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeatActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText, detailsEditText;
    private Button sendButton, cleanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feat);

        sendButton.setOnClickListener(this);
        detailsEditText.setOnClickListener(this);

        init();
    }

    private void init() {
        nameEditText = findViewById(R.id.editTextId);
        detailsEditText = findViewById(R.id.editTextDetailsId);
        sendButton = findViewById(R.id.sendbutton1Id);
        cleanButton = findViewById(R.id.clearbuttonId);
    }

    @Override
    public void onClick(View v) {
        try {

            String name = nameEditText.getText().toString();
            String message = detailsEditText.getText().toString();

            if (v.getId() == R.id.sendbutton1Id) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"urahamat@gmail.com"});

                intent.putExtra(Intent.EXTRA_SUBJECT, "Show Subjects extra_subject");
                intent.putExtra(Intent.EXTRA_TEXT, "Name extra_text :" + name + "\n Message Use" + message);
                startActivity(Intent.createChooser(intent, "Sho createChooser"));


            } else if (v.getId() == R.id.clearbuttonId) {

                nameEditText.setText(" ");
                detailsEditText.setText(" ");


            }

        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "Exception :" + e, Toast.LENGTH_SHORT).show();

        }


    }

}

