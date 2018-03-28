package com.example.fredenbe20.pong_fredenbe20;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.example.fredenbe20.pong_fredenbe20.Animation.Animator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by fredenbe20 on 3/21/2018.
 * Mason Fredenberg
 */

public class PongGame implements Animator {
    Random rand = new Random();//RNG
    ArrayList <Ball> activeBalls = new ArrayList<>();//holds all Ball objects on screen
    private int width = 2000;//max x dimension
    private int height = 1500;//max y dimension

    //initializing both paddles
    Paddle humanPaddle = new Paddle(width - 30, (height/2) - 100, width, (height/2) + 150);
    ComputerPaddle compPaddle = new ComputerPaddle(0, (height/2) - 100, 30, (height/2) + 150);


    @Override
    public int interval() {
        return 30;
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
        if(activeBalls.isEmpty()){
            activeBalls.add(new Ball(rand.nextInt(50), rand.nextInt(50),
                    rand.nextInt(20) + 10, rand.nextBoolean(), rand.nextBoolean()));
        }
        //drawing borders
        Paint walls = new Paint();
        walls.setColor(Color.CYAN);
        canvas.drawRect(0, 0, width, 30, walls );
        //canvas.drawRect(0, 0, 30, height, walls);
        canvas.drawRect(0, height - 30, width, height, walls);
        compPaddle.moveTowardBall(activeBalls.get(0).getyCoord());


        //drawing the paddles
        compPaddle.drawPaddle(canvas, walls);
        humanPaddle.drawPaddle(canvas, walls);

        //either increments or decrements based on the two booleans
        for (Ball b: activeBalls) {
            if(b.isxBackwards()) {
                b.decxCount();
            }
            else{
                b.incxCount();
            }
            if(b.isyBackwards()){
                b.decyCount();
            }
            else{
                b.incyCount();
            }
        }
        //math for coordinates of each ball and if they need to bounce
        for (Ball b : activeBalls) {
            int xNum = (b.getxCount()*b.getSpeed());
            int yNum = (b.getyCount()*b.getSpeed());

                if(xNum > 10 && xNum <= width && yNum > 10 && yNum <= height){

                }else {
                    b.randomCoords(rand.nextInt(20), rand.nextInt(20));
                }

            b.setxCoord(xNum);
            b.setyCoord(yNum);

            if(b.getyCoord() >= height-30 || b.getyCoord() < 30){
                b.switchyBackwards();
            }
            if(xNum <= compPaddle.getRight() && yNum >= compPaddle.getTop() && yNum <= humanPaddle.getBottom()){
                b.switchxBackwards();

            }
            if(xNum > width){
                b.randomCoords(rand.nextInt(50), rand.nextInt(50));

            }


            if(xNum >= humanPaddle.getLeft()  && yNum >= humanPaddle.getTop() && yNum <= humanPaddle.getBottom()){
                    b.switchxBackwards();
            }



        }

        //paints ball
        Paint red = new Paint();
        red.setColor(Color.RED);
        for (Ball b: activeBalls) {
            canvas.drawCircle(b.getxCoord(), b.getyCoord(), 20, red);
        }



    }

    @Override
    public void onTouch(MotionEvent event) {
        /**
         External Citation
         Date: 27 March 2018
         Problem: Couldnt figure out how to get the location of the touch
         Resource:
         https://stackoverflow.com/questions/3476779/how-to-get-the-touch-position-in-android
         Solution: event.getY();
         */

        int y = (int)event.getY();

        humanPaddle.updatePosition(y);
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {


        }
    }

    public void addBall(){
        activeBalls.add(new Ball(rand.nextInt(width), rand.nextInt(height), rand.nextInt(20)+10,
                rand.nextBoolean(), rand.nextBoolean()));
    }





}
