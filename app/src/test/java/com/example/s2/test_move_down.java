package com.example.s2;

import static org.junit.Assert.assertEquals;

import com.example.s2.game.Direction;
import com.example.s2.game.Player;

import org.junit.Test;

public class test_move_down {

    @Test
    public void moveDownChangesDirection() {
        Player player = new Player.Builder()
                .x(0)
                .y(0)
                .direction(Direction.UP)
                .build();
        player.move(Direction.DOWN);
        assertEquals(Direction.DOWN, player.getDirection());
    }

    @Test
    public void moveDownChangesCoordinates() {
        Player player = new Player.Builder()
                .x(25)
                .y(25)
                .direction(Direction.UP)
                .build();
        player.move(Direction.DOWN);
        assertEquals(25, player.getX());
        assertEquals(26, player.getY());
    }
}
