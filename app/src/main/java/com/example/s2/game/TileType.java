package com.example.s2.game;

import com.example.s2.R;

public enum TileType {
    GOAL(R.drawable.goal_tile),
    ROAD(R.drawable.road_tile),
    SAFE(R.drawable.safe_tile),
    STARTING(R.drawable.starting_tile),
    WATER(R.drawable.water_tile);

    private int backgroundId;

    TileType(int backgroundId) {
        this.backgroundId = backgroundId;
    }

    public int getBackgroundId() {
        return backgroundId;
    }
}
