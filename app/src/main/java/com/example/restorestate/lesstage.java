package com.example.restorestate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class lesstage extends AppCompatActivity {
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesstages);
        LinearLayout image = (LinearLayout) findViewById(R.id.lalistedestage);
        image.setAnimation(AnimationUtils.loadAnimation(this,R.anim.close_main));
        lacolordebuttin();
    }
    private void lacolordebuttin() {
        int A[] = new int[]{R.id.level1, R.id.level2, R.id.level3, R.id.level4, R.id.level5, R.id.level6, R.id.level7, R.id.level8, R.id.level9, R.id.level10};
        int i;
        for (i=0; i < A.length; i++ ){
            Button BN = (Button) findViewById(A[i]);
            if (!testlestage(A[i]))
                BN.setBackgroundResource(R.drawable.buttoninactive);
        }
    }
    private boolean testlestage(int y){
        Intent li=getIntent();
        x = li.getIntExtra("ent",1);
        switch (y){
            case R.id.level1:
                return true;
            case R.id.level2:
                if(x>15)
                    return true;
                else
                return false;
            case R.id.level3:
                if(x>30)
                    return true;
                else
                return false;
            case R.id.level4:
                if(x>45)
                    return true;
                else
                return false;
            case R.id.level5:
                if(x>60)
                    return true;
                else
                return false;
            case R.id.level6:
                if(x>75)
                    return true;
                else
                return false;
            case R.id.level7:
                if(x>90)
                    return true;
                else
                return false;
            case R.id.level8:
                if(x>105)
                    return true;
                else
                return false;
            case R.id.level9:
                if(x>120)
                    return true;
                else
                return false;
            case R.id.level10:
                if(x>135)
                    return true;
                else
                return false;
        }
        return false;
    }
    private int[] leselementsestage(int y){
        Intent li=getIntent();
        x = li.getIntExtra("ent",1);
        int []A;
        switch (y){
            case R.id.level1:
                    A = new int[]{1,1,1,1, 1, 2, 1, 2, 1};
                return A;
            case R.id.level2:
                    A = new int[]{2,1, 2, 2, 1, 2, 1, 2, 1, 3, 3, 2, 1, 2, 1};
                    return A;
            case R.id.level3:
                    A = new int[]{3,3, 2, 2, 3, 2, 5, 2, 1, 3, 3, 2, 1, 2, 1, 3, 3};
                    return A;
            case R.id.level4:
                    A=new int[]{4,3,2,4,3,2,4,2,4,3,3,2,4,2,4,4,3,3};
                    return A;
            case R.id.level5:
                    A=new int[]{5,3,5,5,3,2,4,2,1,3,3,5,1,5,1,5,3,3};
                    return A;
            case R.id.level6:
                    A=new int[]{6,3,5,5,3,2,4,2,4,3,3,5,1,5,1,5,3,3,6,6};
                    return A;
            case R.id.level7:
                    A=new int[]{7,3,5,5,3,2,4,2,4,3,3,5,1,5,1,5,3,3,6,6,4,4};
                    return A;
            case R.id.level8:
                A=new int[]{8,3,5,5,3,4,4,2,4,3,6,5,1,5,4,5,3,3,6,6,4,4};
                    return A;
            case R.id.level9:
                    A=new int[]{9,3,5,5,3,6,4,6,4,3,3,5,5,5,1,5,3,3,6,6,4,4};
                    return A;
            case R.id.level10:
                    A=new int[]{10,3,5,5,3,6,4,6,4,3,3,5,5,5,6,5,3,3,6,6,4,4,5,6};
                    return A;
        }
        return null;
    }
    public void choixstage(View view) {
               if(testlestage(view.getId())){
                   Intent intent;
                   intent = new Intent(lesstage.this, Setruselta.class);
                   int []A=leselementsestage(view.getId());
                   intent.putExtra("entre1",A);
                   intent.putExtra("ent1",x);
                   startActivity(intent);
               }
               else
                   Toast.makeText(this, "Level is closed ", Toast.LENGTH_SHORT).show();
    }
}
