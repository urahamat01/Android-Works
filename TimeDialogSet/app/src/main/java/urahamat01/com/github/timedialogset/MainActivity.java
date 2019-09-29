package urahamat01.com.github.timedialogset;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button button;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find value
        textView = findViewById(R.id.textViewId);
        button = findViewById(R.id.buttonId);
        //find text
       // textView.setOnClickListener(this);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        //datePicker get day , month , year
        DatePicker datePicker = new DatePicker(this);
        int currentDay = datePicker.getDayOfMonth();
        int currentMonth = datePicker.getMonth();
        int currentYear = datePicker.getYear();

        //datePickerDialog opject create OndateSetListener create
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                textView.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }

        }, currentYear, currentMonth, currentDay);
        datePickerDialog.show();

    }
}
