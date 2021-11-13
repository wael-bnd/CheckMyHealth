package enis.tn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {
    private MediaPlayer mPlayer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView splashIcon = (ImageView) findViewById(R.id.imageView);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        //anim.setDuration(3000);
        splashIcon.startAnimation(anim);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            //faire animer l'image
            public void onAnimationStart(Animation animation) {
                setVolumeControlStream(AudioManager.STREAM_MUSIC);
                mPlayer = MediaPlayer.create(SplashScreenActivity.this, R.raw.welcome);
                mPlayer.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (mPlayer != null) {
                    mPlayer.stop();
                    mPlayer.reset();
                    mPlayer.release();
                }
                Intent i = new Intent(SplashScreenActivity.this, MenuActivity.class);
                startActivity(i);

            }

            public void onAnimationRepeat(Animation animation){

            }
        });


    }
}
