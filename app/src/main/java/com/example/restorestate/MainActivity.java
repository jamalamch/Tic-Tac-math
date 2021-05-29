package com.example.restorestate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    TextView next_number;   //Current Fibonacci number on screen
    Bundle extras ;
    int x;
    SharedPreferences sharedPreferences;
    RelativeLayout image;
    ImageView image1;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-5351451076922075~6532560122");
        mAdView = (AdView) findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        image =(RelativeLayout)findViewById(R.id.information1);
        image1 = (ImageView) findViewById(R.id.imageV);
        image1.setAnimation(AnimationUtils.loadAnimation(this,R.anim.open_next));

         extras = getIntent().getExtras();
         sharedPreferences = getBaseContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        if (extras == null && sharedPreferences.contains("stage") && sharedPreferences.contains("points")) {

            x = sharedPreferences.getInt("stage", 0);
            int point = sharedPreferences.getInt("points", 0);

            Toast.makeText(this, "Les point : " + x, Toast.LENGTH_SHORT).show();

        } else {
            //si aucun utilisateur n'est sauvegardé, on ajouter [24,florent]
            sharedPreferences
                    .edit()
                    .putInt("stage", 1)
                    .putInt("points", 0)
                    .apply();
                     x=1;
            Toast.makeText(this, "Sauvegardé, relancez l'application pour voir le résultat", Toast.LENGTH_SHORT).show();
        }
        Intent i1 = getIntent();
        if (extras != null) {
                  x = i1.getIntExtra("sortie",1);
                  Toast.makeText(this, "Les point: " + x, Toast.LENGTH_SHORT).show();
                  sharedPreferences.edit().putInt("stage", x).apply();
        }



        //Link next_number to screen TextView
        next_number = (TextView) findViewById(R.id.textView2);
        next_number.setText(String.valueOf(x));
    }
    public void HandleClick(View v) {
        Intent intent;
        intent = new Intent(MainActivity.this, lesstage.class);
        intent.putExtra("ent",x);
        startActivity(intent);}

    public void About(View view) {
        Button info = (Button)findViewById(R.id.information);
        ScrollView scroll =(ScrollView)findViewById(R.id.scrole);
        scroll.setVisibility(View.VISIBLE);
        image.removeView(info);
    }


       /* texte.setBackgroun
    /*
    //For Button presses (linked via onClick attribute)
    public void HandleClick(View arg0) {
        //Load previous number from the state
        long previous_number = number_state;
        //Update the state (from the screen) prior to next calculation
        number_state = Long.parseLong(next_number.getText().toString());
        //Calculate next Fibonacci number and update screen
        next_number.setText(Long.toString(number_state + previous_number));
    }
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("PREVIOUS", number_state);
    }
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        number_state=savedInstanceState.getLong("PREVIOUS");
    }*/
}
