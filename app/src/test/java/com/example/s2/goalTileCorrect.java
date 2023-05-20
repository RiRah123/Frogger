package com.example.s2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.example.s2.game.Tile;
import com.example.s2.game.TileType;

public class goalTileCorrect {
    @Test
    public void goalTileCorrect() {
        Tile tile = new Tile();
        tile.setTileType(TileType.GOAL);
        assertEquals(tile.getType(), TileType.GOAL);
    }
}