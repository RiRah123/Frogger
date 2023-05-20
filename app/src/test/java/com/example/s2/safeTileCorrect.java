package com.example.s2;

import com.example.s2.game.Tile;
import com.example.s2.game.TileType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class safeTileCorrect {
    @Test
    public void safeTileCorrect() {
        Tile tile = new Tile();
        tile.setTileType(TileType.SAFE);
        assertEquals(tile.getType(), TileType.SAFE);
    }
}