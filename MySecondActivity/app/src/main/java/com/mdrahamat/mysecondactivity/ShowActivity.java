package com.mdrahamat.mysecondactivity;

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
    private List<User> userList;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        init();
        getData();
    }

    private void getData() {
        Cursor cursor = databaseHelper.showData();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(databaseHelper.COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(databaseHelper.COL_NAME));
            String age = cursor.getString(cursor.getColumnIndex(databaseHelper.COL_AGE));
            userList.add(new User(id, name, age));
            userAdapter.notifyDataSetChanged();
        }


    }

    private void init() {

        userList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseHelper = new DatabaseHelper(this);
        userAdapter = new UserAdapter(userList);
        VerticalItemSelecter verticalItemSelecter = new VerticalItemSelecter(10);
        recyclerView.addItemDecoration(verticalItemSelecter);
        recyclerView.setAdapter(userAdapter);
    }
}
