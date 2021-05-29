package com.example.restorestate;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
		ImageView image = (ImageView)findViewById(R.id.premp);
		image.setBackgroundColor(0xe1ffffff);
        image.setAnimation(AnimationUtils.loadAnimation(this,R.anim.open_main));
		/** Creates a count down timer, which will be expired after 5000 milliseconds */
        new CountDownTimer(1500,100) {
        	/** This method will be invoked on finishing or expiring the timer */
			@Override
			public void onFinish() {
				/** Creates an intent to start new activity */
				Intent intent = new Intent(getBaseContext(), MainActivity.class);
				//memulai activity baru ketika waktu timer habis
				startActivity(intent);
				//menutup layar activity
				finish();

			}

			@Override
			public void onTick(long millisUntilFinished) {

			}
		}.start();
        
    }
}