package urahamat01.com.github.timehoure;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button button;
    private TextView textView;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.buttonId);
        textView = findViewById(R.id.textViewId);

        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        TimePicker timePicker = new TimePicker(this);
        int currentHoure = timePicker.getCurrentHour();
        int currentMinit = timePicker.getCurrentMinute();

        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                textView.setText(hourOfDay + ":" + minute);

            }
        }, currentHoure, currentMinit, true);

        timePickerDialog.show();

    }
}
