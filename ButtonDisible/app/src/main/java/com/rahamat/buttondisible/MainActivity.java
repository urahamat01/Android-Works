package com.rahamat.buttondisible;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextPassword;
    private Button buttonConform;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextNameId);
        editTextPassword = findViewById(R.id.editTextPasswordId);
        buttonConform = findViewById(R.id.button_conformId);


        editTextName.addTextChangedListener(loginTextWatcher);
        editTextPassword.addTextChangedListener(loginTextWatcher);
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String userNameInput = editTextName.getText().toString().trim();
            String passwordInput = editTextPassword.getText().toString().trim();
            buttonConform.setEnabled(!userNameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
