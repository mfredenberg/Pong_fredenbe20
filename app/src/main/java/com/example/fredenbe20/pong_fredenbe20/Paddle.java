package com.example.fredenbe20.pong_fredenbe20;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by fredenbe20 on 3/27/2018.
 * Mason Fredenberg
 */

public class Paddle {
    private int top;
    private int left;
    private int bottom;
    private int right;
    private double midToEnd; //distance from middle of paddle to either end
    private double middle;

    public Paddle(int initLeft, int initTop, int initRight, int initBottom){
        top = initTop;
        left = initLeft;
        bottom = initBottom;
        right = initRight;
        middle = (bottom+ top)/2;
        midToEnd = middle - top;
    }




    public boolean updatePosition(int y){
        middle = y;
        top = y - (int)midToEnd;
        bottom = y + (int)midToEnd;

        return true;
    }

    public void drawPaddle(Canvas cavnas, Paint paddlePaint){
        cavnas.drawRect(left, top, right, bottom, paddlePaint);
    }

    public int getTop(){return top;}
    public int getLeft(){return left;}
    public int getBottom(){return bottom;}
    public int getRight(){return right;}

}
