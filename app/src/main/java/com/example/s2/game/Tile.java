package com.example.s2.game;

import com.example.s2.R;

public class Tile {
    private TileType tileType;

    public Tile(TileType tileType) {
        this.tileType = tileType;
    }

    public Tile() {

    }

    public TileType getType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    public int getLayoutId() {
        return R.layout.tile_layout;
    }

    public TileType getTileType() {
        return tileType;
    }
}

