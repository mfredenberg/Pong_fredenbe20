package com.example.fredenbe20.pong_fredenbe20;

import android.os.Bundle;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.example.fredenbe20.pong_fredenbe20.Animation.AnimationSurface;

/**
 * PongMainActivity
 *
 * This is the activity for the Pong game. It attaches a PongAnimator to
 * an AnimationSurface.
 *
 * @author Andrew Nuxoll
 * @author Steven R. Vegdahl
 * @version July 2013
 *
 */
public class PongMainActivity extends Activity implements View.OnClickListener{

    /**
     * creates an AnimationSurface containing a PongGame.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pong_main);

        // Connect the animation surface with the animator
        AnimationSurface mySurface = (AnimationSurface) this
                .findViewById(R.id.animationSurface);
        final PongGame pongGame = new PongGame();
        mySurface.setAnimator(pongGame);

        Button ballButton = (Button) this.findViewById(R.id.ballButton);
        ballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pongGame.addBall();
            }
        });

    }


    @Override
    public void onClick(View v) {

    }
}
