package com.example.fredenbe20.pong_fredenbe20;

/**
 * Created by fredenbe20 on 3/27/2018.
 */

public class ComputerPaddle extends Paddle {

    public ComputerPaddle(int initLeft, int initTop, int initRight, int initBottom){
        super(initLeft, initTop, initRight, initBottom);
    }

    public void moveTowardBall(int ballPos){
        if(this.getMiddle() < ballPos){
            this.setMiddle(this.getMiddle() + 20);
        }
    }




}
