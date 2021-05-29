package com.example.restorestate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;



public class Setruselta extends AppCompatActivity {
    Testbien testbien ;
    View.OnClickListener buttonClickListener;
    private int a[];
    private int A[];
    private int J=1;
    private int X;
    private int life=3;
    private LayoutParams layoutParams;
    private LinearLayout linearLayout;
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private LinearLayout linearLayout3_1;
    private LinearLayout linearLayout4;
    private FloatingActionButton button1;
    private ProgressBar progressBar;
    private EditText editText1;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testbien);
        MobileAds.initialize(this, "ca-app-pub-5351451076922075~6532560122");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.setMargins(15, 10, 15, 10); // (left, top, right, bottom)
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        linearLayout1 = (LinearLayout) findViewById(R.id.frame1);
        linearLayout2 = (LinearLayout) findViewById(R.id.frame2);
        linearLayout3 = (LinearLayout) findViewById(R.id.frame3);
        linearLayout3_1=(LinearLayout)findViewById(R.id.frame4);
        linearLayout4 = (LinearLayout) findViewById(R.id.linearLayout2);
        progressBar =(ProgressBar)findViewById(R.id.progressBar);


        buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.idA:
                     //   textswivant();
                        linearLayout1.removeAllViews();
                        linearLayout2.removeAllViews();
                        linearLayout3.removeAllViews();
                        linearLayout3_1.removeAllViews();
                        linearLayout4.removeAllViews();
                        chosiertest(J++);

                        break;
                    default:
                        lifeplay(life-1);
                        break;
                }
            }
        };
        Intent i1 = getIntent();
        A =i1.getIntArrayExtra("entre1");
        X =i1.getIntExtra("ent1",1);
        nomberstage(A[0]);
        progressBar.setMax(A.length+1);
        chosiertest(J);
    }
    private void chosiertest(int i){
        progressBar.setProgress(i);
        if(i<A.length-1) {
            linearLayout.setAnimation(AnimationUtils.loadAnimation(this,R.anim.close_next));
            Log.i("debut", "lefonction:" + A[i+1]);
            switch (A[i+1]) {
                case 1:
                    lestest4(1);
                    break;
                case 2:
                    leteste3(1);
                    break;
                case 3:
                    leteste1_2(1);
                    break;
                case 4:
                    leteste1_2(2);
                    break;
                case 5:
                    lestest4(2);
                    break;
                case 6:
                    leteste3(2);
                    break;
                default:
                    if (i % 3 == 0)
                        leteste3(2);
                    else if (i % 2 == 0)
                        lestest4(2);
                    else
                        leteste1_2(2);
                    break;
            }
        }
            else
                if(A[0]>X/15)
                     textswivant(15);
                 else
                     textswivant(0);
    }
    private void nomberstage(int x){
        TextView texe1=(TextView)findViewById(R.id.star);
        TextView text2 =(TextView)findViewById(R.id.fine);
        texe1.setText(String.valueOf(x));
        text2.setText(String.valueOf(x+1));
    }
    private void inserlanomber2(int x){

        int i=(x<9) ? 6 : 9;
        int j=(int) (Math.random() * 3);
        if(j == 2) {
            i=9;
            testbien = new Testbien(i);
            testbien.foction2((int) (Math.random() * X / 10 + 1));
        }
        else {
            testbien = new Testbien(i);
            testbien.choiselefonction(X);
        }
        a=testbien.a;
        if(i==6){
            for (i = 0; i < a.length / 2; i++) {
                affichge1(String.valueOf(a[i]), linearLayout1);
                caseof(i,j,linearLayout1);
            }
            for (i = a.length / 2; i < a.length - 1; i++) {
                affichge1(String.valueOf(a[i]), linearLayout2);
                caseof(i,j,linearLayout2);
            }
            affichge1("??",linearLayout2);
        }
        else {
            for (i = 0; i < a.length / 3; i++) {
                affichge1(String.valueOf(a[i]), linearLayout1);
                caseof(i,j,linearLayout1);
            }
            for (i = a.length / 3; i < a.length * 2 / 3; i++) {
                affichge1(String.valueOf(a[i]), linearLayout2);
                caseof(i,j,linearLayout2);
            }
            for (i = a.length * 2 / 3; i < a.length - 1; i++) {
                affichge1(String.valueOf(a[i]), linearLayout3);
                caseof(i,j,linearLayout3);
            }
            affichge1("??", linearLayout3);
        }
    }
    private void caseof(int i,int c,LinearLayout p) {
        if(c==2)
        switch (i){
            case 0:
            case 3:
            case 6:
                affichge2("+",p);
                break;
            case 1:
            case 4:
            case 7:
                affichge2("=",p);
                break;
            default:
                break;
        }
        else
            affichge2("►",p);

    }
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    private void lifeplay(int x){
        life =x;
        if(life < 0){
            recreate();
            progressBar.setProgress(1);
            J=1;
            chosiertest(J);
    } else{
            ImageView image = (ImageView)findViewById(R.id.imageView1+life);
            image.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "eroure pas varis ", Toast.LENGTH_SHORT).show();
        }

    }
    public void affichge1(String x,LinearLayout p){
       TextView textView2 = new TextView(this);
       textView2.setLayoutParams(layoutParams);
       textView2.setPadding(25, 20, 25, 20);// in pixels (left, top, right, bottom)
       textView2.setText(x);
       textView2.setTextColor(R.color.textcolor1);
       textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
       textView2.setBackgroundResource(R.drawable.viewnomber); // hex color 0xAARRGGBB
       p.addView(textView2);
    }
    public void affichge2(String x,LinearLayout p){
        TextView textView2 = new TextView(this);
        LayoutParams layoutParams2 = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams2.gravity = Gravity.CENTER;
        textView2.setLayoutParams(layoutParams);
        textView2.setPadding(3, 5, 3, 5);// in pixels (left, top, right, bottom)
        textView2.setText(x);
        textView2.setTextColor(0xDB080202);
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        p.addView(textView2);
    }
    public void addeditetext(){
        editText1 = new EditText(this);
        LayoutParams layoutParams2 = new LayoutParams(900,LayoutParams.WRAP_CONTENT);
        layoutParams2.gravity = Gravity.CENTER;
        layoutParams2.setMargins(15, 10, 30, 10);
        editText1.setLayoutParams(layoutParams2);
        editText1.setPadding(60, 10, 60, 10);// in pixels (left, top, right, bottom)
        editText1.setId(R.id.idA);
        editText1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        editText1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
        editText1.setTextColor(0xa4ffffff);
        editText1.setEms(10);
        editText1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        editText1.setBackgroundResource(R.drawable.textview11);
        linearLayout4.addView(editText1);

        button1 = new FloatingActionButton(this);
        button1.setLayoutParams(layoutParams);
        button1.setImageResource(R.drawable.ic_action_name);
        button1.setId(R.id.idB);
        linearLayout4.addView(button1);
    }
    public void afficheimge(int resource,LinearLayout p){
        ImageView image1 = new ImageView(this);
        LayoutParams layoutParams2 = new LayoutParams(LayoutParams.MATCH_PARENT,190);
        layoutParams2.weight=1;
        layoutParams2.gravity = Gravity.CENTER;
        layoutParams2.setMargins(0, 0, 0, 0);
        image1.setLayoutParams(layoutParams2);
        image1.setImageResource(resource);
        p.addView(image1);
    }
    public void afficherbutton(String x,int id){
        Button textView2 = new Button(this);
        textView2.setLayoutParams(layoutParams);
        textView2.setText(x);
        textView2.setId(id);
        textView2.setTextColor(0xa4ffffff);
        textView2.setOnClickListener(buttonClickListener);
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        textView2.setBackgroundResource(R.drawable.leschoixclic); // hex color 0xAARRGGBB
        linearLayout4.addView(textView2);
    }
    public void affichelechoix(int A){
        int i=(int)(Math.random()*3+1);
        switch (i){
            case 1:
                afficherbutton(String.valueOf(A),R.id.idA);
                afficherbutton(String.valueOf(A-(int)(Math.random()*22+1)),R.id.idB);
                afficherbutton(String.valueOf(A+(int)(Math.random()*22+1)),R.id.idC);
                break;
            case 2:
                afficherbutton(String.valueOf(A-(int)(Math.random()*22+1)),R.id.idB);
                afficherbutton(String.valueOf(A),R.id.idA);
                afficherbutton(String.valueOf(A+(int)(Math.random()*22+1)),R.id.idC);
                break;
            default:
                afficherbutton(String.valueOf(A+(int)(Math.random()*22+1)),R.id.idB);
                afficherbutton(String.valueOf(A-(int)(Math.random()*22+1)),R.id.idC);
                afficherbutton(String.valueOf(A),R.id.idA);
                break;
        }
    }
    void choixletypedesaiser(int B,int x){
        switch (x){
            case 2:
                addeditetext();
                buttunclicktest(B);
                break;
            case 1:
                affichelechoix(B);
                break;
            default:
                break;
        }
    }
    void buttunclicktest(final int B){
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TextView textView1 = (TextView) findViewById(editText1.getId());

                if (!textView1.getText().toString().matches("")) {
                    int nombrecree = Integer.valueOf(textView1.getText().toString());
                    if (nombrecree == B) {
                        linearLayout1.removeAllViews();
                        linearLayout2.removeAllViews();
                        linearLayout3.removeAllViews();
                        linearLayout3_1.removeAllViews();
                        linearLayout4.removeAllViews();
                        chosiertest(J++);
                    } else {
                        lifeplay(life-1);
                    }
                } else {
                    Snackbar.make(view, "NUUUUUL !!!! ", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }

        });
    }
    void leteste1_2(int x) {
             inserlanomber2(x*6);
        choixletypedesaiser(a[a.length-1],x);

    }
    void leteste3(int x){
        int i=(int)(Math.random()*4+1);
        int A=(int)(Math.random()*40+1);
        int B=(int)(Math.random()*40+1);
        int CC;
        switch(i){
            case 1:
                affichge1(String.valueOf(A),linearLayout1);
                affichge2("+",linearLayout1);
                affichge1(String.valueOf(B),linearLayout1);
                affichge2("=",linearLayout1);
                affichge1("??",linearLayout1);
                CC = A+B;
                break;
            case 2:
                affichge1(String.valueOf(A),linearLayout1);
                affichge2("-",linearLayout1);
                affichge1(String.valueOf(B),linearLayout1);
                affichge2("=",linearLayout1);
                affichge1("??",linearLayout1);
                CC = A-B;
                break;
            case 3:
                affichge1(String.valueOf(A),linearLayout1);
                affichge2("×",linearLayout1);
                affichge1(String.valueOf(B),linearLayout1);
                affichge2("=",linearLayout1);
                affichge1("??",linearLayout1);
                CC = A*B;
                break;
            default :
                affichge1(String.valueOf(A),linearLayout1);
                affichge2("/",linearLayout1);
                affichge1(String.valueOf(B),linearLayout1);
                affichge2("=",linearLayout1);
                affichge1("??",linearLayout1);
                CC = A/B;
                break;
        }
        choixletypedesaiser(CC,x);
    }
    void lestest4(int x){
        int photo[]=new int[]{R.drawable.animale1,R.drawable.animale2,R.drawable.animale3
                ,R.drawable.animale4,R.drawable.animale5,R.drawable.animale6,
                R.drawable.animale7,R.drawable.animale8,R.drawable.animale9,
                R.drawable.animale10,R.drawable.animale11,R.drawable.animale12};
        int A=(int)(Math.random()*22+1),B=(int)(Math.random()*22+1),C=(int)(Math.random()*22+1);
        int j,t,i;
do{
    i=(int)(Math.random()*12);
    j=(int)(Math.random()*12);
    t=(int)(Math.random()*12);
}while(i == j ||  i==t || t==j );

        afficheimge(photo[i],linearLayout1);
        affichge2("+",linearLayout1);
        afficheimge(photo[i],linearLayout1);
        afficheimge(photo[i],linearLayout2);
        affichge2("+",linearLayout2);
        afficheimge(photo[j],linearLayout2);
        if(x==2) {
            affichge2("+",linearLayout1);
            afficheimge(photo[i],linearLayout1);
            affichge2("=",linearLayout1);
            affichge1(String.valueOf(A*3),linearLayout1);

            affichge2("+",linearLayout2);
            afficheimge(photo[j],linearLayout2);
            affichge2("=",linearLayout2);
            affichge1(String.valueOf(A+2*B),linearLayout2);

            afficheimge(photo[t],linearLayout3);
            if(j%3==0) {
                affichge2("+", linearLayout3);
                afficheimge(photo[j], linearLayout3);
                affichge2("=", linearLayout3);
                affichge1(String.valueOf(B + C), linearLayout3);

                afficheimge(photo[i],linearLayout3_1);
                affichge2("-",linearLayout3_1);
                afficheimge(photo[t],linearLayout3_1);
                affichge2("+",linearLayout3_1);
                afficheimge(photo[j],linearLayout3_1);
                affichge2("=",linearLayout3_1);
                affichge1("??", linearLayout3_1);
                B=A-B+C;
            }
            else if(j%2 == 0 ){
                affichge2("-", linearLayout3);
                afficheimge(photo[j], linearLayout3);
                affichge2("=", linearLayout3);
                affichge1(String.valueOf(C-B), linearLayout3);

            afficheimge(photo[i],linearLayout3_1);
            affichge2("+",linearLayout3_1);
            afficheimge(photo[t],linearLayout3_1);
            affichge2("+",linearLayout3_1);
            afficheimge(photo[j],linearLayout3_1);
            affichge2("=",linearLayout3_1);
            affichge1("??", linearLayout3_1);
            B=A+B+C;}
            else{
                affichge2("-", linearLayout3);
                afficheimge(photo[j], linearLayout3);
                affichge2("=", linearLayout3);
                affichge1(String.valueOf(C-B), linearLayout3);

                afficheimge(photo[i],linearLayout3_1);
                affichge2("+",linearLayout3_1);
                afficheimge(photo[t],linearLayout3_1);
                affichge2("×",linearLayout3_1);
                afficheimge(photo[j],linearLayout3_1);
                affichge2("=",linearLayout3_1);
                affichge1("??", linearLayout3_1);
                B=A+B*C;
            }
        }else {
            affichge2("=",linearLayout1);
            affichge1(String.valueOf(A*2),linearLayout1);

            affichge2("=", linearLayout2);
            affichge1(String.valueOf(A + B), linearLayout2);
        afficheimge(photo[j],linearLayout3);
        affichge2("=",linearLayout3);
        affichge1("??",linearLayout3);
    }
        choixletypedesaiser(B,x);
    }
    public void textswivant(int x) {
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        intent.putExtra("sortie", X+x);
        startActivity(intent);
    }

}
