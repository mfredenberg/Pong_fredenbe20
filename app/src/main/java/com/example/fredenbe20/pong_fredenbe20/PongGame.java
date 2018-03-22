package com.example.fredenbe20.pong_fredenbe20;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

/**
 * Created by fredenbe20 on 3/21/2018.
 */

public class PongGame implements Animator {
    private int count = 0;
    private boolean goBackwards = false;
    private int width = 0;
    private int height = 0;
    private int speed = 20;

    @Override
    public int interval() {
        return 20;
    }

    @Override
    public int backgroundColor() {
        return Color.rgb(0, 0,0);
    }

    @Override
    public boolean doPause() {
        return false;
    }

    @Override
    public boolean doQuit() {
        return false;
    }

    @Override
    public void tick(Canvas canvas) {
        if(goBackwards) {
            count--;
        }
        else{
            count++;
        }

        int wNum = (count*speed)%width;
        int hNum = (count*speed)%height;

        if(wNum >= width){
            goBackwards = true;
        }
    }

    @Override
    public void onTouch(MotionEvent event) {

    }


    public void setWidth(int newWidth){width = newWidth;}
    public void setHeight(int newHeight){height = newHeight;}
}
