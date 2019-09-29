package urahamat01.com.github.registerfrom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText firstNameET, lastNameET, emailET, passwordET;
    private AutoCompleteTextView radioButtonACTV;
    private CheckBox checkboxBT;
    private Button buttonSU;
    private String [] bloodgroup ={"A+","A-","B+","B-","O+","O-","AB+","AB-"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //type casting
        init();

        //arrayAdapter set mainactivity and R.layout/and blood group
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,bloodgroup);

        radioButtonACTV.setAdapter(adapter);
        //miniam suarch
        radioButtonACTV.setThreshold(1);


        firstNameET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.firstNameET){
                    Toast.makeText(MainActivity.this, "Entered Your First Name", Toast.LENGTH_SHORT).show();

                }
            }
        });

        lastNameET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.lastNameET){
                    Toast.makeText(MainActivity.this, "Enterd Your last Name", Toast.LENGTH_SHORT).show();

                }
            }
        });
        emailET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.emailET){
                    Toast.makeText(MainActivity.this, "Enterd email", Toast.LENGTH_SHORT).show();

                }
            }
        });
        passwordET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.passwordET){
                    Toast.makeText(MainActivity.this, "Enterd password", Toast.LENGTH_SHORT).show();

                }
            }
        });
        checkboxBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.checkboxBT){
                    Toast.makeText(MainActivity.this, "checkbox Ok", Toast.LENGTH_SHORT).show();

                }
            }
        });
      checkboxBT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              if (isChecked==true){
                 buttonSU.setVisibility(View.VISIBLE);

              }else{
                  buttonSU.setVisibility(View.GONE);
              }

          }
      });
        radioButtonACTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.radioButtonACTV){
                    Toast.makeText(MainActivity.this, "Entered Blood group", Toast.LENGTH_SHORT).show();

                }
            }
        });

        buttonSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.buttonSU){
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void init() {

        firstNameET = findViewById(R.id.firstNameET);
        lastNameET = findViewById(R.id.lastNameET);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        radioButtonACTV = findViewById(R.id.radioButtonACTV);
        checkboxBT = findViewById(R.id.checkboxBT);
        buttonSU = findViewById(R.id.buttonSU);
    }



}
