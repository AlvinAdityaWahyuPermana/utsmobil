package umn.ac.id.uts_mobile_26780;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;


public class PlayerMusic2 extends AppCompatActivity implements View.OnClickListener{

    //Deklarasi Variable
    View buttonplay, buttonstop, image;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_music2);


        //Inisialisasi Button
        buttonplay = findViewById(R.id.buttonplay);
        buttonstop = findViewById(R.id.buttonstop);
        image = findViewById(R.id.image);
//        about = findViewById(R.id.about);

        //Menambahkan Listener pada Button
        buttonplay.setOnClickListener(this);
        buttonstop.setOnClickListener(this);
//        about.setOnClickListener(this);

        //membuat scroll
//        final TextView tv = (TextView) findViewByid(R.id.Lyric);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollViewlyric);
        final Handler timerHandler = new Handler();
        final Runnable timerRunnable = new Runnable() {
            @Override
            public void run() {
                scrollView.smoothScrollBy(0,1);
                timerHandler.postDelayed(this,50);
            }
        };



        final ObjectAnimator anim = ObjectAnimator.ofFloat(image, View.ROTATION, 0.0f, 360.0f)
                .setDuration(4000);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setInterpolator(new LinearInterpolator());
        anim.start();
        anim.pause();

        mediaPlayer = MediaPlayer.create(this, R.raw.lazysong);

        buttonplay.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    anim.resume();
                    timerHandler.postDelayed(timerRunnable, 9000);
                }
                else{
                    mediaPlayer.pause();
                    anim.pause();
                    timerHandler.removeCallbacks(timerRunnable);
                }
            }
        });
        buttonstop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    anim.pause();
                    timerHandler.removeCallbacks(timerRunnable);
                    try {
                        //Menyetel audio ke status awal
                        mediaPlayer.prepare();
                        mediaPlayer.seekTo(0);
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
                else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    anim.pause();
                    timerHandler.removeCallbacks(timerRunnable);
                    try {
                        //Menyetel audio ke status awal
                        mediaPlayer.prepare();
                        mediaPlayer.seekTo(0);
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonplay:
                break;

            case R.id.buttonstop:
                break;
        }
    }

}


