package com.mdrahamat.firebaseapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.muddzdev.styleabletoast.StyleableToast;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int PICK_IMAGE_REQUEST = 1;
    private Button mButtonChoseImage;
    private Button mButtonUploadImage;
    private TextView mTextViewShowUpload;
    private EditText mEditTextFileName;
    private ImageView mImageView;
    private ProgressBar mProgressBer;

    private Uri mImageUri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");


        mButtonChoseImage.setOnClickListener(this);
        mButtonUploadImage.setOnClickListener(this);
        mTextViewShowUpload.setOnClickListener(this);
    }

    private void init() {
        mButtonChoseImage = findViewById(R.id.button_view_imageId);
        mButtonUploadImage = findViewById(R.id.uploadButtonId);
        mTextViewShowUpload = findViewById(R.id.textViewUploadId);
        mEditTextFileName = findViewById(R.id.editTextId);
        mImageView = findViewById(R.id.image_view);
        mProgressBer = findViewById(R.id.progressBerId);

    }

    public void ShowToast(View view) {

        StyleableToast.makeText(this, "Hellow Would", R.style.exampleToast).show();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_view_imageId) {
            openFileChooser();
        } else if (v.getId() == R.id.uploadButtonId) {
            if (mUploadTask != null && mUploadTask.isInProgress()) {
                Toast.makeText(MainActivity.this, "Upload IS Progress", Toast.LENGTH_SHORT).show();

            } else {
                uploadFile();
            }

        } else if (v.getId() == R.id.textViewUploadId) {

        }
    }


    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            mImageUri = data.getData();
            Picasso.with(this).load(mImageUri).into(mImageView);
            // mImageView.setImageURI(mImageUri);
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));

    }

    private void uploadFile() {

        if (mImageUri != null) {
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(mImageUri));

            mUploadTask = fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBer.setProgress(0);
                        }
                    }, 5000);
                    Toast.makeText(MainActivity.this, "upload this successfully", Toast.LENGTH_SHORT).show();

                    Upload upload = new Upload(mEditTextFileName.getText().toString().trim(),
                            taskSnapshot.getMetadata().toString());
                    String uploadId = mDatabaseRef.push().getKey();
                    mDatabaseRef.child(uploadId).setValue(upload);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                    double progress = (100 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                    mProgressBer.setProgress((int) progress);
                }
            });
        } else {
            Toast.makeText(this, "Not File Select ", Toast.LENGTH_SHORT).show();
        }

    }
}
