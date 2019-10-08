package com.rahamat.mymediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView play, off;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.playId);
        off = findViewById(R.id.offId);
        mediaPlayer = MediaPlayer.create(this, R.raw.bensoundsummer);

        play.setOnClickListener(this);
        off.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.playId) {
            if (mediaPlayer != null) {
                mediaPlayer.start();
                int value = mediaPlayer.getDuration()/1000;
                Toast.makeText(this, "Song start" + value, Toast.LENGTH_SHORT).show();
            }

        }
        if (v.getId() == R.id.offId) {
            if (mediaPlayer != null) {
                mediaPlayer.start();
                Toast.makeText(this, "Song paused", Toast.LENGTH_SHORT).show();
            }


        }

    }

    @Override
    protected void onDestroy() {

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
