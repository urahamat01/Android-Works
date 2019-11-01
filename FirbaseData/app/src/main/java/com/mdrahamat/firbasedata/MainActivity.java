package com.mdrahamat.firbasedata;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nameEt, emailEt, ageEt, bloadgroupEt;
    private Button insertBtn;
    public String name, email, age, bloadgroup;
    private DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> mUserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameEt.getText().toString().trim();
                email = emailEt.getText().toString().trim();
                age = ageEt.getText().toString().trim();
                bloadgroup = bloadgroupEt.getText().toString().trim();
                addInDB(name, email, age, bloadgroup);

            }
        });


    }

    private void addInDB(String name, String email, String age, String bloadgroup) {

        DatabaseReference databaseRef = databaseReference.child("users");
        User user = new User(name, email, age, bloadgroup);
        databaseRef.push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successfully added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "No data Insert", Toast.LENGTH_SHORT).show();
                }
            }
        });

        getData();


    }

    private void getData() {
        DatabaseReference userRef = databaseReference.child("users");
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        User users = data.getValue(User.class);
                        mUserList.add(users);
                        userAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void init() {
        nameEt = findViewById(R.id.nameExtId);
        emailEt = findViewById(R.id.emailExtId);
        ageEt = findViewById(R.id.ageExtId);
        bloadgroupEt = findViewById(R.id.bloadExtId);
        insertBtn = findViewById(R.id.insertBtnId);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        mUserList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(mUserList);
        recyclerView.setAdapter(userAdapter);
    }
}
