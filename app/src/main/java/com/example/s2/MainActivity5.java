package com.example.s2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity5 extends BaseActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        button = (Button) findViewById(R.id.restart_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        quitGame();

        // Retrieve the score extra from the intent
        int score = getIntent().getIntExtra("score", 0);
        // Find the score TextView and set its text to "Score: <score>"
        TextView scoreTextView = (TextView) findViewById(R.id.score_textview);
        scoreTextView.setText("Score: " + score);

        TextView messageTextView = (TextView) findViewById(R.id.congrats_textview);
        String name = getIntent().getStringExtra("name");
        messageTextView.setText("Congratulations! " +  name + " won the game!");

    }
}