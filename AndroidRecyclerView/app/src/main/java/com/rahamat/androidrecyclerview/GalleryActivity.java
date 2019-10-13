package com.rahamat.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";
    String imageurl;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started Successfully");
        getIncommingIntent();

    }

    private void getIncommingIntent() {

        Log.d(TAG, "getIncommingIntent: getIncommingIntent");

        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("imageName")){
            Log.d(TAG, "getIncommingIntent: imageUrl");
             imageurl = getIntent().getStringExtra("image_url");
             imageName = getIntent().getStringExtra("imageName");

            setImage ();

        }

    }

    private void setImage() {

        //image Description

        Log.d(TAG, "setImage: setImage");

        //text description find
        TextView name = findViewById(R.id.image_descriptionId);
        //        //text set
        name.setText(imageName);


        //imageVew find
        ImageView imageView = findViewById(R.id.image);


        //glide use image view
        Glide.with(this)
                .asBitmap()
                .load(imageurl)
                .into(imageView);

    }


}
