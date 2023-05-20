package com.example.s2;

import androidx.appcompat.app.AppCompatActivity;



import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;

import android.os.Bundle;
import android.util.DisplayMetrics;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity3 extends AppCompatActivity {

    private boolean drown = true;

    private int initialX; // it should be the bottom middle of the screen

    private float imageXPosition;

    private int initialY;
    private float initialTouchX;
    private float initialTouchY;

    //attempting to create a variable to store avatar current location
    private float currentTouchX;

    private float currentTouchY;

    private float tempTouchX;

    private float tempTouchY;

    private boolean leftSafe;

    private boolean leftRoad;

    private boolean leftSafe2;

    private boolean leftRiver;

    private int score;

    private int liveNum;

    private int maxScore;

    private boolean deadDrown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        leftSafe = false;
        leftRoad = false;
        leftSafe2 = false;
        leftRiver = false;
        score = 0;
        deadDrown = false;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView textView = (TextView) findViewById(R.id.difficulty_text);
        TextView lives = (TextView) findViewById(R.id.lives_left);
        ImageView vehicle1 = (ImageView) findViewById(R.id.vehicle1);
        ImageView vehicle2 = (ImageView) findViewById(R.id.vehicle2);
        ImageView vehicle3 = (ImageView) findViewById(R.id.vehicle3);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        liveNum = 0;

        // check radiobuttons from mainactivity2
        int selectedId = getIntent().getIntExtra("selected_id", -1);

        if (selectedId == R.id.radioButton) {
            textView.setText("Difficulty: Easy"); // easy
            liveNum = 3;
            lives.setText("Lives Left " + liveNum);
        } else if (selectedId == R.id.radioButton2) {
            textView.setText("Difficulty: Medium"); // medium
            liveNum = 2;
            lives.setText("Lives Left: " + liveNum);
        } else if (selectedId == R.id.radioButton3) {
            textView.setText("Difficulty: Hard"); // hard
            liveNum = 1;
            lives.setText("Lives Left: " + liveNum);
        }

        TextView points = (TextView) findViewById(R.id.points);
        points.setText("Points: 0");

        String name = getIntent().getStringExtra("name");
        TextView textView2 = (TextView) findViewById(R.id.game_name);
        textView2.setText("Name: " + name);

        ImageView spriteImageView = (ImageView) findViewById(R.id.sprite);

        int spriteNum = getIntent().getIntExtra("selected_sprite", 1);
        if (spriteNum == 1) {
            spriteImageView.setImageResource(R.drawable.sprite1);
        } else if (spriteNum == 2) {
            spriteImageView.setImageResource(R.drawable.sprite2);
        } else {
            spriteImageView.setImageResource(R.drawable.sprite3);
        }

        //create navigation for the sprite, but make sure it can't get out of the screen.

        spriteImageView.setOnTouchListener(new View.OnTouchListener() {


            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = v.getLeft();
                        initialY = v.getTop();
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        System.out.println(initialTouchX + ", " + initialTouchY);
                        if (currentTouchX == 0) {
                            currentTouchX = initialTouchX;
                        }
                        if (currentTouchY == 0) {
                            currentTouchY = initialTouchY;
                        }
                        return true;
                    case MotionEvent.ACTION_UP:
                        ImageView goalTile = (ImageView) findViewById(R.id.goal_tile);
                        if (spriteImageView.getY() < goalTile.getY() + goalTile.getHeight()) {
                            Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
                            intent.putExtra("score", 10);
                            intent.putExtra("name", name);
                            startActivity(intent);
                        }

                        currentTouchX = tempTouchX;
                        currentTouchY = tempTouchY;
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        //check if frog drowned

                        if (deadDrown) {
                            deadDrown = false;
                        }

                        int xDiff = (int) (event.getRawX() - currentTouchX);
                        int yDiff = (int) (event.getRawY() - currentTouchY);
                        int newX = (int) currentTouchX + xDiff - 80;
                        int newY = (int) currentTouchY + yDiff - 100;

                        int parentWidth = ((ViewGroup) v.getParent()).getWidth() - 2;
                        int parentHeight = ((ViewGroup) v.getParent()).getHeight() - 2;
                        int spriteWidth = v.getWidth();
                        int spriteHeight = v.getHeight();
                        // Make sure the sprite can't move off the left or right edges of the screen
                        newX = Math.max(newX, 0);
                        newX = Math.min(newX, parentWidth - spriteWidth);
                        // Make sure the sprite can't move off the top or bottom edges of the screen
                        newY = Math.max(newY, 0);
                        newY = Math.min(newY, parentHeight - spriteHeight);
                        v.animate().x(newX).y(newY).setDuration(0).start();
                        tempTouchX = newX;
                        tempTouchY = newY;

                        if (currentTouchY < 1500 && !leftSafe) {
                            score += 1;
                            leftSafe = true;
                        } else if (currentTouchY < 900 && !leftRoad) {
                            score += 2;
                            leftRoad = true;
                        } else if (currentTouchY < 600 && !leftSafe2) {
                            score += 3;
                            leftSafe2 = true;
                        } else if (currentTouchY < 450 && !leftRiver) {
                            score += 4;
                            leftRiver = true;
                        }

                        TextView points = (TextView) findViewById(R.id.points);
                        points.setText("Points: " + score);

                        //check if the sprite is in the water










                        return true;
                    default:
                        return false;
                }

            }

        });

        ObjectAnimator translateXAnimation =
                ObjectAnimator.ofFloat(vehicle3, "translationX", -screenWidth, screenWidth);

        translateXAnimation.setRepeatCount(ValueAnimator.INFINITE);


        AnimatorSet set = new AnimatorSet();
        AnimatorSet set2 = new AnimatorSet();
        AnimatorSet set3 = new AnimatorSet();
        set.setDuration(5000);
        set.playTogether(translateXAnimation);
        set.start();

        //vehicle 2 animator
        ObjectAnimator translateXAnimation2 =
                ObjectAnimator.ofFloat(vehicle2, "translationX", screenWidth, -screenWidth);

        translateXAnimation2.setRepeatCount(ValueAnimator.INFINITE);

        set2.setDuration(10000);
        set.playTogether(translateXAnimation2);
        set.start();

        //vehicle 1 animator
        ObjectAnimator translateXAnimation1 =
                ObjectAnimator.ofFloat(vehicle1, "translationX", -screenWidth, screenWidth);

        translateXAnimation1.setRepeatCount(ValueAnimator.INFINITE);


        set3.setDuration(2500);
        set3.playTogether(translateXAnimation1);
        set3.start();

        //--------------log--------------

        AnimatorSet setLog = new AnimatorSet();

        AnimatorSet setLog2 = new AnimatorSet();


        ImageView log = (ImageView) findViewById(R.id.log_tile);


        ObjectAnimator translateXAnimation3 =
                ObjectAnimator.ofFloat(log, "translationX", -screenWidth, screenWidth);

        translateXAnimation3.setRepeatCount(ValueAnimator.INFINITE);

        setLog.setDuration(10000);
        setLog.playTogether(translateXAnimation3);

        setLog.start();

        ImageView log2 = (ImageView) findViewById(R.id.log_tile2);

        ObjectAnimator translateXAnimation4 =
                ObjectAnimator.ofFloat(log2, "translationX", screenWidth, -screenWidth);

        translateXAnimation4.setRepeatCount(ValueAnimator.INFINITE);

        setLog2.setDuration(14000);

        setLog2.playTogether(translateXAnimation4);

        setLog2.start();


        translateXAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imageXPosition = (Float) animation.getAnimatedValue();
                //vehicle3 collision
                if (Math.abs((int) vehicle3.getY() - (int) currentTouchY) < 50
                        && Math.abs((int) imageXPosition - (int) currentTouchX) < 50) {
                    //                    print vehicle and sprite x,y coordinates


                    liveNum -= 1;
                    TextView lives = (TextView) findViewById(R.id.lives_left);
                    lives.setText("Lives: " + liveNum);
                    maxScore = Math.max(score, maxScore);
                    if (liveNum == 0) {
                        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                        intent.putExtra("score", maxScore);
                        startActivity(intent);
                    }
                    score = 0;
                    points.setText("Points: " + score);
                    currentTouchX = 0;
                    currentTouchY = 0;



                    spriteImageView.setX(screenWidth / 2 - 50);
                    spriteImageView.setY(screenHeight - 150);
                } else if (Math.abs((int) vehicle2.getY() - (int) currentTouchY) < 50
                        && Math.abs((int) imageXPosition - (int) currentTouchX) < 50) {
                    //                    print vehicle and sprite x,y coordinates


                    liveNum -= 1;
                    TextView lives = (TextView) findViewById(R.id.lives_left);
                    lives.setText("Lives: " + liveNum);
                    maxScore = Math.max(score, maxScore);
                    if (liveNum == 0) {
                        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                        intent.putExtra("score", maxScore);
                        startActivity(intent);
                    }
                    score = 0;
                    points.setText("Points: " + score);
                    currentTouchX = 0;
                    currentTouchY = 0;


                    spriteImageView.setX(screenWidth / 2 - 50);
                    spriteImageView.setY(screenHeight - 150);
                } else if (Math.abs((int) vehicle1.getY() - (int) currentTouchY) < 50
                        && Math.abs((int) imageXPosition - (int) currentTouchX) < 50) {


                    liveNum -= 1;
                    TextView lives = (TextView) findViewById(R.id.lives_left);
                    lives.setText("Lives: " + liveNum);
                    maxScore = Math.max(score, maxScore);
                    if (liveNum == 0) {
                        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                        intent.putExtra("score", maxScore);
                        startActivity(intent);
                    }
                    score = 0;
                    points.setText("Points: " + maxScore);
                    currentTouchX = 0;
                    currentTouchY = 0;


                    spriteImageView.setX(screenWidth / 2 - 50);
                    spriteImageView.setY(screenHeight - 150);
                }

                //rectangle collision for sprite on the log
                Rect spriteRect = new Rect((int) spriteImageView.getX(),
                        (int) spriteImageView.getY(),
                        (int) spriteImageView.getX() + spriteImageView.getWidth(),
                        (int) spriteImageView.getY() + spriteImageView.getHeight());
                Rect log1Rect = new Rect((int) log.getX(), (int) log.getY(),
                        (int) log.getX() + log.getWidth(), (int) log.getY()
                        + log.getHeight());
                Rect log2Rect = new Rect((int) log2.getX(), (int) log2.getY(),
                        (int) log2.getX() + log2.getWidth(), (int) log2.getY()
                        + log2.getHeight());


                if (Rect.intersects(spriteRect, log1Rect)) {
                    spriteImageView.setX((float) (spriteImageView.getX() + 2.8));
                } else if (Rect.intersects(spriteRect, log2Rect)) {
                    spriteImageView.setX((float) (spriteImageView.getX() - 1.95));
                }

                //losing a life if goes off screen
                if ((-5 > spriteImageView.getX() || spriteImageView.getX() > screenWidth)
                        || (!(Rect.intersects(spriteRect, log1Rect)
                        || Rect.intersects(spriteRect, log2Rect))
                        && (spriteImageView.getY() < 600
                        && spriteImageView.getY() > 375)) && !deadDrown) {
                    deadDrown = true;
                    currentTouchX = 0;
                    currentTouchY = 0;
                    tempTouchX = 0;
                    tempTouchY = 0;

                    spriteImageView.setY(screenHeight - 150);
                    spriteImageView.setX(screenWidth / 2 - 50);

                    TextView lives = (TextView) findViewById(R.id.lives_left);
                    liveNum -= 1;
                    lives.setText("Lives Left: " + liveNum);
                    maxScore = Math.max(score, maxScore);
                    if (liveNum == 0) {
                        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                        intent.putExtra("score", maxScore);
                        startActivity(intent);
                    }
                    score = 0;
                    points.setText("Points: " + score);



                }
            }
        });
    }
}
