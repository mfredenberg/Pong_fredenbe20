package com.example.fredenbe20.pong_fredenbe20;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
    private String difficulty = "Easy";

    @Override
    public int interval() {
        return 20;
    }

    @Override
    public int backgroundColor() {
        return Color.rgb(210, 210, 210);
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
        Paint walls = new Paint();
        walls.setColor(Color.CYAN);
        canvas.drawRect(0, 0, width, 30, walls );
        canvas.drawRect(0, 0, 30, height, walls);
        canvas.drawRect(0, height - 30, width, height, walls);
        if(difficulty.equals("Easy")){
            canvas.drawRect(width - 30, height/3, width, height * (2/3), walls);

        } else{
            canvas.drawRect(width - 30, (height/2) - 100, width, (height/2) + 100, walls);
        }

        if(goBackwards) {
            count--;
        }
        else{
            count++;
        }

        int xNum = (count*speed)%width;
        int yNum = (count*speed)%height;

        if(xNum >= width || xNum < 0){
            goBackwards = !goBackwards;
        }
        if(yNum >= height || yNum < 0){
            goBackwards = !goBackwards;
        }
    }

    @Override
    public void onTouch(MotionEvent event) {

    }


    public void setWidth(int newWidth){width = newWidth;}
    public void setHeight(int newHeight){height = newHeight;}
}
