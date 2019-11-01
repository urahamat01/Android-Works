package com.mdrahamat.firebaseimage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends AppCompatActivity {
    private ImageAdapter mImageAdapter;
    private RecyclerView mRecyclerView;
    private DatabaseReference mDatabaseRef;
    private ProgressBar mProgressCircle;

    private List<Upload> mUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        init();
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Upload upload = postSnapshot.getValue(Upload.class);
                    mUpload.add(upload);
                }
                mImageAdapter = new ImageAdapter(ImagesActivity.this,mUpload);
                mRecyclerView.setAdapter(mImageAdapter);
                mProgressCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ImagesActivity.this, "", Toast.LENGTH_SHORT).show();

                mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void init() {
        mRecyclerView = findViewById(R.id.recyclerViewId);
        mRecyclerView.setHasFixedSize(true);
        mProgressCircle = findViewById(R.id.progress_Id);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUpload = new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");


    }
}
