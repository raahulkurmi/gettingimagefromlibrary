package com.example.musicplayerapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button play,pause,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        stop=findViewById(R.id.stop);



        MediaPlayer mpplayer=new MediaPlayer();
        mpplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String apath="android.resource://"+getPackageName()+"/raw/pasoori";
//      String onlinepath="https://wynk.in/music/playlist/bollywood-love-cafe-hindi-fb/bb_1521105396817#queue";

        Uri upath=Uri.parse(apath);
//        Uri onlineuri=Uri.parse(onlinepath);


        try {
            mpplayer.setDataSource(this,upath);
            mpplayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        play.setOnClickListener(view -> mpplayer.start());

        pause.setOnClickListener(view -> mpplayer.pause());
        stop.setOnClickListener(view -> {
            mpplayer.pause();
            mpplayer.seekTo(0);
        });
//        mpplayer.getDuration();
//        mpplayer.getCurrentPosition();

//        mpplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//
//            }
//        });
    }
}