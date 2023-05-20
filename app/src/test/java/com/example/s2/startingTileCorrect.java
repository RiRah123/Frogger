package com.example.s2;


import com.example.s2.game.Tile;
import com.example.s2.game.TileType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class startingTileCorrect {
    @Test
    public void startingTileCorrect() {
        Tile tile = new Tile();
        tile.setTileType(TileType.STARTING);
        assertEquals(tile.getType(), TileType.STARTING);
    }
}
