package urahamat01.com.github.checkboxlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxSuger;
    private CheckBox checkBoxWater;
    private Button buttonId;
    private TextView textViewShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxSuger = findViewById(R.id.checkBoxSuger);
        checkBoxWater = findViewById(R.id.checkBoxWater);
        buttonId = findViewById(R.id.buttonId);
        textViewShow = findViewById(R.id.textViewShow);

        buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                if (checkBoxMilk.isChecked()) {
                    String value = checkBoxMilk.getText().toString();
                    stringBuilder.append(value + "");

                }
                if (checkBoxSuger.isChecked()) {
                    String value = checkBoxSuger.getText().toString();
                    stringBuilder.append(value + "");

                }
                if (checkBoxWater.isChecked()) {
                    String value = checkBoxWater.getText().toString();
                    stringBuilder.append(value + "");

                }
                textViewShow.setText(stringBuilder + "Show Buy items" + "\n");

            }

        });


    }
}
