package com.example.fredenbe20.pong_fredenbe20;

/**
 * Created by fredenbe20 on 3/22/2018.
 */

public class Ball {
    private int xCoord;
    private int yCoord;
    private int speed;
    private int xCount;
    private int yCount;
    private boolean xBackwards;
    private boolean yBackwards;

    public Ball(int newX, int newY, int newSpeed, boolean xBack, boolean yBack){
        xCoord = newX;
        yCoord = newY;
        speed = newSpeed;
        xCount = 0;
        yCount = 0;
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


}
