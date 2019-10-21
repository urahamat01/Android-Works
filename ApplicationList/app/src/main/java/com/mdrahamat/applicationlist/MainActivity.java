package com.mdrahamat.applicationlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = "MainActivity";
    
    private ListView mListView;
    private ArrayList<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: onCreate");
        init();

        Log.d(TAG, "onCreate: onCreate User");

        Person person = new Person("Rahamat", "12/01/2019", "Male");
        Person person2 = new Person("Rony", "12/01/2019", "Male");
        Person person3 = new Person("Suny", "12/01/2019", "Male");
        Person person4 = new Person("Bithday", "12/01/2019", "Male");
        Person person5 = new Person("Rhaman", "12/01/2019", "Male");
        Person person6 = new Person("People", "12/01/2019", "Male");
        Person person7 = new Person("Rahamat Ullah", "12/01/2019", "Male");
        Person person8 = new Person("Rahamat Ullah", "12/01/2019", "Male");
        Person person9 = new Person("Rahamat Ullah", "12/01/2019", "Male");
        Person person10 = new Person("Rahamat Ullah", "12/01/2019", "Male");
        Person person11 = new Person("Rahamat Ullah", "12/01/2019", "Male");
        Person person12 = new Person("Rahamat", "12/01/2019", "Male");

        personList.add(person);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        personList.add(person7);
        personList.add(person8);
        personList.add(person9);
        personList.add(person10);
        personList.add(person11);
        personList.add(person12);

        Toast.makeText(this, "nameIn", Toast.LENGTH_SHORT).show();
        PersonAdapter adapter = new PersonAdapter(this, R.layout.adapter_view_layout, personList);
        mListView.setAdapter(adapter);
    }

    private void init() {
        mListView = findViewById(R.id.listView);
        personList = new ArrayList<>();
    }
}
