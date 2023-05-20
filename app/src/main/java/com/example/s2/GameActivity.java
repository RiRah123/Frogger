package com.example.s2;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.s2.game.Tile;
import com.example.s2.game.GameInfo;
import com.example.s2.game.TileType;

import java.util.List;

public class GameActivity extends AppCompatActivity {

    private LinearLayout tileContainer;
    private List<Tile> tiles;


    public static int getScreenWidth(Context context) {
        WindowManager windowManager =
                (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GameInfo gameInfo = createGameInfo();

        TextView difficultyView = findViewById(R.id.difficulty_text);
        TextView livesView = findViewById(R.id.lives_left);
        difficultyView.setText(gameInfo.getDifficulty());
        livesView.setText(gameInfo.getLivesLeft());

        TextView pointsView = findViewById(R.id.points);
        pointsView.setText("Points: " + gameInfo.getPoints());

        TextView nameView = findViewById(R.id.game_name);
        nameView.setText("Name: " + gameInfo.getName());

        createTiles(gameInfo.getSelectedId());
    }

    private GameInfo createGameInfo() {
        int selectedId = getIntent().getIntExtra("selected_id", -1);
        String name = getIntent().getStringExtra("name");

        String difficulty;
        String livesLeft;
        if (selectedId == R.id.radioButton) {
            difficulty = "Difficulty: Easy";
            livesLeft = "Lives Left: 3";
        } else if (selectedId == R.id.radioButton2) {
            difficulty = "Difficulty: Medium";
            livesLeft = "Lives Left: 2";
        } else if (selectedId == R.id.radioButton3) {
            difficulty = "Difficulty: Hard";
            livesLeft = "Lives Left: 1";
        } else {
            difficulty = "";
            livesLeft = "";
        }

        return new GameInfo(selectedId, name, difficulty, livesLeft, 0);
    }

    private Tile[][] createTiles(int selectedId) {
        Tile[][] grid = new Tile[10][5];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 5; col++) {
                Tile tile = new Tile();
                if (row == 9 && col == 2) {
                    tile.setTileType(TileType.STARTING);
                } else if (row == 0 && col == 2) {
                    tile.setTileType(TileType.GOAL);
                } else if (row == 2 || row == 4) {
                    tile.setTileType(TileType.ROAD);
                } else if (row == 6 || row == 7) {
                    tile.setTileType(TileType.WATER);
                } else {
                    tile.setTileType(TileType.SAFE);
                }
                grid[row][col] = tile;
            }
        }
        return grid;
    }
}
