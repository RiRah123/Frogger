package com.example.s2;

import com.example.s2.game.Tile;
import com.example.s2.game.TileType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class roadTileCorrect {

    @Test
    public void roadTileCorrect() {
        Tile tile = new Tile();
        tile.setTileType(TileType.ROAD);
        assertEquals(tile.getType(), TileType.ROAD);
    }
}
