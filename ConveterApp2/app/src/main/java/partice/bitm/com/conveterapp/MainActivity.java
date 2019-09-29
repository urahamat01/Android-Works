package partice.bitm.com.conveterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RadioButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    private Button btnConvert;
    private TextView viewResult;
    private String amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btnConvert = findViewById(R.id.btnConvert);
        viewResult = findViewById(R.id.viewResult);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = editText.getText().toString();

                //onClickListenerButton();
                if (amount.equals("")) {

                    Toast.makeText(MainActivity.this, "Please enter your amount", Toast.LENGTH_LONG).show();

                } else {

                    if (btn1.isChecked()) {
                        double finalAmount = Double.valueOf(amount);
                        double result = finalAmount * 12;
                        viewResult.setText(String.valueOf(result));
                    } else if (btn2.isChecked()) {

                        double finalAmount = Double.valueOf(amount);
                        double result = finalAmount / 12;
                        viewResult.setText(String.valueOf(result));

                    } else if (btn3.isChecked()) {

                        double finalAmount = Double.valueOf(amount);
                        double result = finalAmount / 1.609344;
                        viewResult.setText(String.valueOf(result));

                    } else if (btn4.isChecked()) {

                        double finalAmount = Double.valueOf(amount);
                        double result = finalAmount * 1.609344;
                        viewResult.setText(String.valueOf(result));

                    } else if (btn5.isChecked()) {

                        double finalAmount = Double.valueOf(amount);
                        double result = finalAmount / 1.609344;
                        viewResult.setText(String.valueOf(result));

                    } else if (btn6.isChecked()) {

                        double finalAmount = Double.valueOf(amount);
                        double result = finalAmount * 1.609344;
                        viewResult.setText(String.valueOf(result));

                    } else if (btn7.isChecked()) {

                        double finalAmount = Double.valueOf(amount);
                        double result = finalAmount * 10;
                        viewResult.setText(String.valueOf(result));

                    } else if (btn8.isChecked()) {

                        double finalAmount = Double.valueOf(amount);
                        double result = finalAmount / 10;
                        viewResult.setText(String.valueOf(result));

                    }
                }
                //     public void onClickListenerButton(){
//                radio_g = (RadioGroup)findViewById(R.id.rg_animals);
//                button_sbn= (Button)findViewById(R.id.button);
//                button_sbm.setOnClickListener(){
//                    public void onClick(View v){
//                        int select_id = radio_g.getCheckedButton();
//                        radio_b = (RadioButton)findViewById(select_id);
//                        Toast.makeText(MainActivity.this, radio_b.getText().toString(), Toast.LENGTH_SHORT).show();
                //       }

                //       }

            }
        });


    }
}
