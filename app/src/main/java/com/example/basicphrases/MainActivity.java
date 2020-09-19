package com.example.basicphrases;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

//    Button[] btnArray = {
//            findViewById(R.id.button1),
//            findViewById(R.id.button2),
//            findViewById(R.id.button3),
//            findViewById(R.id.button4),
//            findViewById(R.id.button5),
//            findViewById(R.id.button6),
//            findViewById(R.id.button7),
//            findViewById(R.id.button8),
//    };

    MediaPlayer mediaPlayer;
    boolean isPlayingMedia = false;
    int persistTag = 0;

 public void playPhrase(View view){
        Button currentBtn = (Button)view;
        int btnTag = Integer.parseInt(currentBtn.getTag().toString());

        if(isPlayingMedia && persistTag == btnTag){
            mediaPlayer.pause();
        }else if(!isPlayingMedia && persistTag == btnTag){
            mediaPlayer.start();
        }  else if(isPlayingMedia && persistTag != btnTag) {
            mediaPlayer.stop();
            mediaPlayer.release();
            assignMediaPlayer(btnTag);
        } else if(mediaPlayer == null){
            assignMediaPlayer(btnTag);
        }

       mediaPlayer.start();
       isPlayingMedia = mediaPlayer.isPlaying();
       persistTag = btnTag;
    }

    private void assignMediaPlayer(int btnTag) {
        switch (btnTag) {
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.doyouspeakenglish);
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.goodevening);
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.hello);
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(this, R.raw.howareyou);
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(this, R.raw.ilivein);
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(this, R.raw.mynameis);
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(this, R.raw.please);
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(this, R.raw.welcome);
                break;
            default:
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}