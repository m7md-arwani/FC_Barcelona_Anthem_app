package com.example.android.audio_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1, b2, b3, b4;
        MediaPlayer fcb = MediaPlayer.create(this, R.raw.bb);


        b1 = (Button) findViewById(R.id.play_button);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                fcb.start();
                fcb.setOnCompletionListener(mp -> {
                    Toast.makeText(getApplicationContext(), "Finished!", Toast.LENGTH_SHORT).show();
                    fcb.release();

                });
            }
        });

        b2 = (Button) findViewById(R.id.pause_button);

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                fcb.pause();
            }
        });

        AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        b3 = (Button) findViewById(R.id.up_button);

        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
            }
        });

        b4 = (Button) findViewById(R.id.down_button);

        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
            }
        });



        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        this.getWindow().getDecorView().setSystemUiVisibility(uiOptions);

        // status bar is hidden. Also, the Action bar should get hidden.
       getSupportActionBar().hide();

    }


}