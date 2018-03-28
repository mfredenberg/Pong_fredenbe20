package com.example.fredenbe20.pong_fredenbe20;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by fredenbe20 on 3/27/2018.
 * Mason Fredenberg
 */

public class Paddle {

    //drawing coordinates
    private int top;
    private int left;
    private int bottom;
    private int right;

    private double midToEnd; //distance from middle of paddle to either end
    private double middle; //current midpoint of paddle


    /*
    Takes in initial coordinates and sets them
    Calculates middle and midToEnd
     */
    public Paddle(int initLeft, int initTop, int initRight, int initBottom){
        top = initTop;
        left = initLeft;
        bottom = initBottom;
        right = initRight;
        middle = (bottom+ top)/2;
        midToEnd = middle - top;
    }



    /*
    Updates the middle, top, and bottom variables when called and a y value is passed in.
     */
    public void updatePosition(int y){
        middle = y;
        top = y - (int)midToEnd;
        bottom = y + (int)midToEnd;
    }

    /*
    dras the paddle at the correct coords given a canvas and paint
     */
    public void drawPaddle(Canvas cavnas, Paint paddlePaint){
        cavnas.drawRect(left, top, right, bottom, paddlePaint);
    }

    //getters & setters
    public int getTop(){return top;}
    public int getLeft(){return left;}
    public int getBottom(){return bottom;}
    public int getRight(){return right;}
    public double getMiddle(){return middle;}
    public double getMidToEnd(){return midToEnd;}
    public void setMiddle(double newMid){middle = newMid;}


}
