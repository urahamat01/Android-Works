package com.rahamat.convertrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contact> contactList;
    private RecyclerView recyclerView;
    private Contact_Adapter contact_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setData();
    }

    private void setData() {
        contactList.add(new Contact("Rahamat", "01754150180", R.drawable.ic_account_user_24dp));
        contactList.add(new Contact("Rahamat", "01754150180", R.drawable.ic_account_user_24dp));
        contactList.add(new Contact("Rahamat", "01754150180", R.drawable.ic_account_user_24dp));
        contact_adapter.notifyDataSetChanged();
    }

    private void init() {
        contactList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        contact_adapter = new Contact_Adapter(contactList,this);
        recyclerView.setAdapter(contact_adapter);
    }
}
