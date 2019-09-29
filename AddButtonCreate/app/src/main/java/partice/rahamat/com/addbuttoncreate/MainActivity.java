package partice.rahamat.com.addbuttoncreate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//implement onclick listener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextAdd, editTextSub;
    private Button buttonAdd, buttonSub;
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //set onClickListener
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
    }

    private void init() {
        //find value
        editTextAdd = findViewById(R.id.editTextAdd);
        editTextSub = findViewById(R.id.editTextSub);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        textViewResult = findViewById(R.id.textViewResult);
    }

    //override onClick listenr method
    @Override
    public void onClick(View v) {

        try{

            //convert into String
            String number1 = editTextAdd.getText().toString();
            String number2 = editTextSub.getText().toString();

            //convert into double
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            //condition follow
            if (v.getId() == R.id.buttonAdd){
                double sub = num1 + num2;
                textViewResult.setText("Result Show "+ sub);

            }else if (v.getId() == R.id.buttonSub){
                double sub = num1 - num2;
                textViewResult.setText("Result Show "+ sub);
            }

        }catch (Exception e){
            //Toast object create and gravity center create  and show() method create
          Toast toast=  Toast.makeText(this, "Entered your number thanks", Toast.LENGTH_SHORT);
          toast.setGravity(Gravity.CENTER,0,0);
          toast.show();

        }

    }
}
