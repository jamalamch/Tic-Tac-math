package com.example.restorestate;

import android.util.Log;

public class Testbien {
    int []a;
     Testbien(int x){ a= new int[x] ;}
    public void choiselefonction(int nivou){
         int h=(int)(Math.random()*nivou/10+1);
         int i=(int)(Math.random()*4+1);
        Log.i("debut", "lefonction:"+i+"lanivoue"+h);
         switch (i){
             case 1:
                 foction1(h);
                 break;
             case 2:
                 foction4(h);
                 break;
             case 3:
                 foction3(h);
                 break;
             default:
                 foction5(h);
                 break;
         }
    }
    public void foction1(int x){
        int i;
        int h = (int) (Math.random() * 5 + 1);
        int g = (int) (Math.random() * 10 + 1);
        a[0] = (int) (Math.random() * 10 + 1);
        switch (x) {
            case 1:
                for (i = 1; i < a.length; i++)
                    a[i] = a[i - 1] + h * g;
                break;
            case 2:
                for (i = 1; i < a.length; i++)
                    a[i] = a[i - 1] - h * g;
                break;
            case 3:
                for (i = 1; i < a.length; i++)
                    a[i] = a[i - 1] * h ;
                break;
            case 4:
                for (i = 1; i < a.length; i++)
                    a[i] = a[i - 1] * h +1 ;
                break;
            case 5:
                for (i = 1; i < a.length; i++)
                    a[i] = a[i - 1] * h -1;
                break;
            default:
                for (i = 1; i < a.length; i++)
                    a[i] = a[i - 1] * h +g;
                break;
        }

    }
    public  void foction2(int x){
        int i;
        int h = (int)(Math.random()*3+1);
        switch (x){
            case 1:
                for(i=0;i<a.length;i++){
                    if(i ==2 || i==5 || i==9)
                        a[i]=a[i-1]+a[i-2];
                    else
                        a[i]=(int)(Math.random()*10);}
                break;
            case 2:
                for(i=0;i<a.length;i++){
                    if(i ==2 || i==5 || i==9)
                        a[i]=a[i-1]-a[i-2];
                    else
                        a[i]=(int)(Math.random()*10);}
                break;
            case 3:
                for(i=0;i<a.length;i++){
                    if(i ==2 || i==5 || i==9)
                        a[i]=a[i-1]*a[i-2];
                    else
                        a[i]=(int)(Math.random()*10);}
                break;
            case 4:
                for(i=0;i<a.length;i++){
                    if(i ==2 || i==5 || i==9)
                        a[i]=a[i-1]*a[i-2]+h;
                    else
                        a[i]=(int)(Math.random()*10);}
                break;
            case 5:
                for(i=0;i<a.length;i++){
                    if(i ==2 || i==5 || i==9)
                        a[i]=a[i-1]+a[i-2]+h;
                    else
                        a[i]=(int)(Math.random()*10);}
                break;
            case 6:
                for(i=0;i<a.length;i++){
                    if(i ==2 || i==5 || i==9)
                        a[i]=a[i-1]+a[i-2]-h;
                    else
                        a[i]=(int)(Math.random()*10);}
                break;
            case 7:
                for(i=0;i<a.length;i++){
                    if(i ==2 || i==5 || i==9)
                        a[i]=a[i-1]-a[i-2]-h;
                    else
                        a[i]=(int)(Math.random()*10);}
                break;
            case 8:
                for(i=0;i<a.length;i++){
                    if(i ==2 || i==5 || i==9)
                        a[i]=a[i-1]-a[i-2]*h;
                    else
                        a[i]=(int)(Math.random()*10);}
                break;
            case 9:
                for(i=0;i<a.length;i++){
                    if(i ==2 || i==5 || i==9)
                        a[i]=a[i-1]+a[i-2]/h;
                    else
                        a[i]=(int)(Math.random()*10);}
                break;
            default:
                for(i=0;i<a.length;i++){
                    if(i ==2 || i==5 || i==9)
                        a[i]=a[i-1]+a[i-2]*h;
                    else
                        a[i]=(int)(Math.random()*10);}
                break;
        }

    }
    public void foction3(int x){
        int i;
        a[0]=(int)(Math.random()*100);
        int h = (int)(Math.random()*10);
        switch (x){
                   case 1:
                       for(i=1;i<a.length;i++)
                           a[i]=a[i-1]+h;
                       break;
                   case 2:
                       for(i=1;i<a.length;i++)
                           a[i]=Math.abs(a[i-1]-h);
                       break;
                   case 3:
                       for(i=1;i<a.length;i++)
                           a[i]=a[i-1]-h;
                       break;
                  case 4:
                      for(i=1;i<a.length;i++)
                          a[i]=a[i-1]/(h/2);
                      break;
                  default:
                      for(i=1;i<a.length;i++)
                          a[i]=a[i-1]/(h/2);
                      break;
               }
    }
    public void foction4(int x){
        int i;
        int g = (int) (Math.random() * 3 + 1);
        a[0] = (int) (Math.random() * 10 + 1);
        a[1]=(int) (Math.random() * 10 + 1);
        switch (x) {
            case 1:
                for (i = 2; i < a.length; i++)
                    a[i] = a[i - 1] + a[i-2];
                break;
            case 2:
                for (i = 2; i < a.length; i++)
                    a[i] = a[i - 1] - a[i-2];
                break;
            case 3:
                for (i = 2; i < a.length; i++)
                    a[i] = a[i - 1] + g*a[i-2] ;
                break;
            case 4:
                for (i = 2; i < a.length; i++)
                    a[i] = a[i - 1] * g +a[i-2] ;
                break;
            case 5:
                for (i = 2; i < a.length; i++)
                    a[i] = a[i - 1] * g-a[i-2] ;
                break;
            default:
                for (i = 2; i < a.length; i++)
                    a[i] = a[i - 1] / g + a[i-2] ;
                break;
        }

    }
    public void foction5(int x) {
        int i;
        int g = (int) (Math.random() * 3 +1);
        a[0] = (int) (Math.random() * 10 + 1);
        switch (x) {
            case 1:
                for (i = 1; i < a.length; i++)
                    a[i] = a[i - 1] + i+1;
                break;
            case 2:
                for (i = 1; i < a.length; i++)
                    a[i] = a[i - 1] - i;
                break;
            case 3:
                for (i = 1; i < a.length; i++)
                    a[i] = a[i - 1] - i+g;
                break;
            default:
                for (i = 1; i < a.length; i++)
                    a[i] = a[i - 1]  + i+g;
                break;
        }
    }
}

