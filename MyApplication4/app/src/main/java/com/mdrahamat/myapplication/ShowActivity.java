package com.mdrahamat.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User>userList;
    private DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        init();
        getData();

    }


    private void getData() {
        Cursor cursor = helper.showData();

        while (cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndex(helper.COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(helper.COL_NAME));
                String age = cursor.getString(cursor.getColumnIndex(helper.COL_AGE));
                userList.add(new User(id,name,age));
                userAdapter.notifyDataSetChanged();
        }
    }


    private void init() {
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userList = new ArrayList<>();
        helper = new DatabaseHelper(this);
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);


    }
}
