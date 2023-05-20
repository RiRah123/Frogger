package com.example.s2;

import com.example.s2.game.Tile;
import com.example.s2.game.TileType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class waterTileCorrect {
    @Test
    public void waterTileCorrect() {
        Tile tile = new Tile();
        tile.setTileType(TileType.WATER);
        assertEquals(tile.getType(), TileType.WATER);
    }
}