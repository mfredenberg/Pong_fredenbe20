package com.example.fredenbe20.pong_fredenbe20;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by fredenbe20 on 3/21/2018.
 * Mason Fredenberg
 */

public class PongGame implements Animator {
    Random rand = new Random();//RNG
    private int width = 2000;//max x dimention
    private int height = 1500;//max y dimention
    private String difficulty = "Easy";//difficulty level
    ArrayList <Ball> activeBalls = new ArrayList<>();//holds all Ball objects on screen


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
        canvas.drawRect(0, 0, 30, height, walls);
        canvas.drawRect(0, height - 30, width, height, walls);

        //paddle based on difficulty
        if(difficulty.equals("Easy")){
            canvas.drawRect(width - 30, height/3, width, (float)(height * (2.0/3.0)), walls);

        } else{
            canvas.drawRect(width - 30, (height/2) - 100, width, (height/2) + 100, walls);
        }
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
            if(xNum < 30){
                b.switchxBackwards();

            }
            if(xNum > width){
                b.randomCoords(rand.nextInt(50), rand.nextInt(50));

            }
            if(difficulty.equals("Easy")){
                if(xNum > width - 30 && yNum >= height/3 && yNum <= (float)(height * (2.0/3.0))){
                    b.switchxBackwards();
                }

            }
            else{
                if(xNum > width && yNum >= (height/2)-100 && yNum <= (height/2)+100){
                    b.switchxBackwards();
                }
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
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            activeBalls.add(new Ball(rand.nextInt(width), rand.nextInt(height), rand.nextInt(20)+10,
                    rand.nextBoolean(), rand.nextBoolean()));
        }
    }


}
