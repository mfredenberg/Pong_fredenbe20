package com.example.fredenbe20.pong_fredenbe20;

import java.util.Random;

/**
 * Created by fredenbe20 on 3/22/2018.
 * Mason Fredenberg
 */

/**
 External Citation
 Date: 20 March 2018
 Problem: Couldnt figure out how to get more than one ball
 Resource:
 Jason Twigg
 Solution: Ball Class
 */
public class Ball {
    private int xCoord;
    private int yCoord;
    private int speed;

    /**
     External Citation
     Date: 20 March 2018
     Problem: Couldnt figure out how to get ball to bounce
     Resource:
     Stelios Papoutsakis
     Solution: Use two booleans and two counts to keep track of each ball.
     */
    private int xCount;
    private int yCount;
    private boolean xBackwards;
    private boolean yBackwards;
    Random rand = new Random();

    public Ball(int newX, int newY, int newSpeed, boolean xBack, boolean yBack){
        speed = newSpeed;
        xCount = newX;
        yCount = newY;
        xBackwards = xBack;
        yBackwards = yBack;
    }

    public int getxCoord(){return xCoord;}
    public int getyCoord(){return yCoord;}
    public int getSpeed(){return speed;}
    public int getxCount(){return xCount;}
    public int getyCount(){return yCount;}
    public boolean isxBackwards(){return xBackwards;}
    public boolean isyBackwards(){return yBackwards;}

    public void setxCoord(int x){xCoord = x;}
    public void setyCoord(int y){yCoord = y;}
    public void setSpeed(int s){speed = s;}
    public void incxCount(){xCount++;}
    public void incyCount(){yCount++;}
    public void decxCount(){xCount--;}
    public void decyCount(){yCount--;}
    public void switchxBackwards(){xBackwards = !xBackwards;}
    public void switchyBackwards(){yBackwards = !yBackwards;}

    public void randomCoords(int x, int y){
        xCount = x;
        yCount = y;
        xBackwards = rand.nextBoolean();
        yBackwards = rand.nextBoolean();
    }

}
