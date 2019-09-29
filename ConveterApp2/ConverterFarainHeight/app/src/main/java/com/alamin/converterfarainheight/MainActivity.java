package com.alamin.converterfarainheight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextView;
    private Button btn;
    private View view;
    private TextView textView;
    private String amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextView = (EditText) findViewById(R.id.editTextView);
        btn = (Button) findViewById(R.id.btnDis);
        view = (View) findViewById(R.id.viewDis);
        textView = (TextView) findViewById(R.id.textViwDis);


        amount = editTextView.getText().toString();


        //-17.2222

        // amount*-17.22222;

        if () {

        }

//       btn.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
////              if (editTextView.setText("");)
////
////
////           }
//       });


    }
}
