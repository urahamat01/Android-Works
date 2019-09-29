package urahamat01.com.github.checkyourgender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radiogroup;
    private RadioButton radioButton;//femailId, mailId;
    private Button buttonShow;
    private TextView textViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//variable inatialization


        init();
    }

    private void init() {
        radiogroup = findViewById(R.id.radiogroupId);
        // femailId = findViewById(R.id.femailId);
        //mailId = findViewById(R.id.mailId);
        radioButton = findViewById(R.id.mailId);
        radioButton = findViewById(R.id.femailId);
        buttonShow = findViewById(R.id.buttonShow);
        textViewId = findViewById(R.id.textViewId);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selected = radiogroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selected);
                String value = radioButton.getText().toString();
                textViewId.setText(value);

            }
        });

    }

}
