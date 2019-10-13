package com.mdrahamat.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ListView listView;
    private EditText editText;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextId);

        listView =findViewById(R.id.listViewId);
        List<String> names = new ArrayList<>();
        names.add("Dhaka");
        names.add("khulana");
        names.add("Barisal");
        names.add("Chatigong");
        names.add("Shalet");
        names.add("Bhala");
        names.add("Pubna");
        names.add("Dhaka");
        names.add("khulana");
        names.add("Barisal");
        names.add("Chatigong");
        names.add("Shalet");
        names.add("Bhala");
        names.add("Pubna");

         arrayAdapter = new ArrayAdapter(MainActivity.this,R.layout.list_item_view,names);
        listView.setAdapter(arrayAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                (MainActivity.this).arrayAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
