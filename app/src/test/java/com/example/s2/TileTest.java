package com.example.s2;

import static org.junit.Assert.assertEquals;

import com.example.s2.game.Tile;
import com.example.s2.game.TileType;

import org.junit.Test;

public class TileTest {
    @Test
    public void testGetType() {
        TileType expected = TileType.SAFE;
        Tile tile = new Tile(expected);
        TileType actual = tile.getType();
        assertEquals(actual, expected);
    }

    @Test
    public void testSetTileType() {
        TileType expected = TileType.GOAL;
        Tile tile = new Tile();
        tile.setTileType(expected);
        assertEquals(tile.getType(), expected);
    }

    @Test
    public void testGetLayoutId() {
        int expectedLayoutId = R.layout.tile_layout;
        Tile tile = new Tile();
        int actualLayoutId = tile.getLayoutId();
        assertEquals(expectedLayoutId, actualLayoutId);
    }


}
