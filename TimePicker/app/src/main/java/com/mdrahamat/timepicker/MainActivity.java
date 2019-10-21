package com.mdrahamat.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.util.Base64;
import android.view.View;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.io.ByteArrayOutputStream;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button datePickerBtn, timePickerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker();
            }
        });

        timePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimePicker();
            }
        });

    }

    private void openTimePicker() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        View view = getLayoutInflater().inflate(R.layout.custom_time_pcker,null);

        Button doneBtn = view.findViewById(R.id.doneBtn);
        final TimePicker timePicker = view.findViewById(R.id.timePicker);

        builder.setView(view);

        final Dialog dialog = builder.create();
        dialog.show();

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss aa");

                @SuppressLint({"NewApi", "LocalSuppress"}) int hour = timePicker.getHour();
                @SuppressLint({"NewApi", "LocalSuppress"}) int min = timePicker.getMinute();

                Time time = new Time(hour,min,0);

                timePickerBtn.setText(timeFormat.format(time));
                dialog.dismiss();

            }
        });



    }

    private void openDatePicker() {

        DatePickerDialog.OnDateSetListener dateSetListener =
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        month = month + 1;

                        String currentDate = year+"/"+month+"/"+day+" 00:00:00";

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

                        Date date = null;

                        try {
                            date = dateFormat.parse(currentDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        datePickerBtn.setText(dateFormat.format(date));

                        long milisec= date.getTime();


                    }
                };

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, dateSetListener, year, month, day);
        datePickerDialog.show();
    }

    private void init() {
        datePickerBtn = findViewById(R.id.datePickerBtn);
        timePickerBtn = findViewById(R.id.timePickerBtn);


    }

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality)
    {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }

    public static Bitmap decodeBase64(String input)
    {
        byte[] decodedBytes = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }
}
