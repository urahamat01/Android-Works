package com.mdrahamat.sqlitedatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView nameTv, ageTv, genderTv;
    private EditText nameEt, ageEt, genderEt, idEt;
    private Button showBTN;
    private Button deleteBtn;

    private Button buttonIn;
    private Button updateBtn;
    private MyDatabase myDatabase;
    private String id, name, age, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = new MyDatabase(this);
        SQLiteDatabase sqLiteDatabase = myDatabase.getWritableDatabase();

        init();

        buttonIn.setOnClickListener(this);
        showBTN.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);

    }

    private void init() {


        showBTN = findViewById(R.id.showBTN);
        nameEt = findViewById(R.id.nameET);
        ageEt = findViewById(R.id.ageET);
        genderEt = findViewById(R.id.genderET);
        idEt = findViewById(R.id.idET);
        buttonIn = findViewById(R.id.insertBTN);
        updateBtn = findViewById(R.id.updateBTN);
        deleteBtn = findViewById(R.id.deleteBTN);
    }

    @Override
    public void onClick(View v) {

        //video 30
        String name = nameEt.getText().toString().trim();
        String age = ageEt.getText().toString().trim();
        String gender = genderEt.getText().toString().trim();
        String id = idEt.getText().toString().trim();


        if (v.getId() == R.id.insertBTN) {
            long ids = myDatabase.insertData(name, age, gender);
            if (ids == -1) {
                Toast.makeText(this, "Unsuccessfully" + id, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, " Successfully " + id, Toast.LENGTH_SHORT).show();
            }

        }

        //video 31
        if (v.getId() == R.id.showBTN) {

            Cursor cursor = myDatabase.showData();

            if (cursor.getCount() == 0) {
                //There is no data display
                showData("Error", "No Data Display");

                Toast.makeText(this, " There is no data ", Toast.LENGTH_SHORT).show();
            }
            StringBuffer stringBuffer = new StringBuffer();

            while (cursor.moveToNext()) {

                stringBuffer.append("ID" + cursor.getString(0) + "\n");
                stringBuffer.append("NAME" + cursor.getString(1) + "\n");
                stringBuffer.append("AGE" + cursor.getString(2) + "\n");
                stringBuffer.append("GENDER" + cursor.getString(3) + "\n");

            }
            showData("Result Seat :", stringBuffer.toString());
        }else if (v.getId()==R.id.updateBTN){

           Boolean isUpdate = myDatabase.updateData(id,name,age,gender);

           if (isUpdate == true){
               Toast.makeText(this, "Data is update", Toast.LENGTH_SHORT).show();
           }else {
               Toast.makeText(this, "Not update", Toast.LENGTH_SHORT).show();
           }


        }
        if (v.getId() == R.id.deleteBTN){

           int value = myDatabase.deleteData(id);

           if (value>0){
               Toast.makeText(this, "Data is Delete", Toast.LENGTH_SHORT).show();
           }else {
               Toast.makeText(this, "Data is Not Delete", Toast.LENGTH_SHORT).show();
           }
        }

    }


    // video 32
    private void showData(String title, String data) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(data);
        builder.setCancelable(true);
        builder.show();

    }


}
