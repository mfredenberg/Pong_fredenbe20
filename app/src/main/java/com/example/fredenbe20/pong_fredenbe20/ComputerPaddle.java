package com.example.fredenbe20.pong_fredenbe20;

/**
 * Created by fredenbe20 on 3/27/2018.
 * Mason Fredenberg
 * Paddle controlled by AI
 */

public class ComputerPaddle extends Paddle {

    public ComputerPaddle(int initLeft, int initTop, int initRight, int initBottom){
        super(initLeft, initTop, initRight, initBottom);//same constructor, nothing new to add
    }

    /*
    Moves the ball toward the ball, allowing it to be fast enough to catch it,
    but also slow enough to miss occasionally
     */
    public void moveTowardBall(int ballPosY){
        if(this.getMiddle() < ballPosY){
            this.updatePosition((int)this.getMiddle() + 20);
            //if the middle is lower than the ball, raise the middle value
        }
        else if(this.getMiddle() > ballPosY){
            this.updatePosition((int)this.getMiddle() - 20);
            //if the middle is higher than the ball, lower the middle value
        }
        else{

        }
    }




}
