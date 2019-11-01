package com.mdrahamat.firebaseimage;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class ImageActivity extends AppCompatActivity {

    public static final int PICK_IMAGE_REQUES = 1;
    private Button mButtonLoad;
    private Button mButtonChoose;
    private EditText mEditTextNameView;
    private TextView mTextViewShowUpload;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private Uri mImageUri;

    private StorageReference storageReference;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        init();
        mButtonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upLoadFile();

            }
        });
        mButtonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageActivity();

            }
        });
        mEditTextNameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void openImageActivity() {
        Intent intent = new Intent(this, ImagesActivity.class);
        startActivity(intent);
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void upLoadFile() {
        if (mImageUri != null) {
            final StorageReference fileStroageRef = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(mImageUri));
            fileStroageRef.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(0);
                                }
                            }, 500);
                            Toast.makeText(ImageActivity.this, "Upload Success", Toast.LENGTH_SHORT).show();
                            Upload upload = new Upload(mEditTextNameView.getText().toString().trim(),
                                    taskSnapshot.getMetadata().toString());

                            String uploadId = databaseReference.push().getKey();
                            databaseReference.child(uploadId).setValue(upload);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ImageActivity.this, " Exception ", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar.setProgress((int) progress);

                        }
                    });
        } else {
            Toast.makeText(this, " No File Selected ", Toast.LENGTH_SHORT).show();
        }

    }

    private void init() {
        mButtonChoose = findViewById(R.id.button_view_imageId);
        mButtonLoad = findViewById(R.id.uploadButtonId);
        mEditTextNameView = findViewById(R.id.editTextId);
        mTextViewShowUpload = findViewById(R.id.textViewUploadId);
        mImageView = findViewById(R.id.image_view);
        mProgressBar = findViewById(R.id.progressBerId);
        storageReference = FirebaseStorage.getInstance().getReference("uploads");
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");

    }
}
