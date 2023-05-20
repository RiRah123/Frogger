package com.example.s2;

import static org.junit.Assert.assertEquals;

import com.example.s2.game.Direction;
import com.example.s2.game.Player;

import org.junit.Test;

public class test_move_left {

    @Test
    public void moveLeftChangesDirection() {
        Player player = new Player.Builder()
                .x(0)
                .y(0)
                .direction(null)
                .build();
        player.move(Direction.LEFT);
        assertEquals(Direction.LEFT, player.getDirection());
    }

    @Test
    public void moveLeftChangesCoordinates() {
        Player player = new Player.Builder()
                .x(25)
                .y(25)
                .direction(Direction.UP)
                .build();
        player.move(Direction.LEFT);
        assertEquals(24, player.getX());
        assertEquals(25, player.getY());
    }
}

