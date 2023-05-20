package com.example.s2;

import static org.junit.Assert.assertEquals;

import com.example.s2.game.Direction;
import com.example.s2.game.Player;

import org.junit.Test;

public class test_move_up {

    @Test
    public void moveUpChangesDirection() {
        Player player = new Player.Builder()
                .x(0)
                .y(0)
                .direction(null)
                .build();

        player.move(Direction.UP);

        assertEquals(player.getDirection(), Direction.UP);
    }

    @Test
    public void moveUpChangesCoordinates() {
        Player player = new Player.Builder()
                .x(25)
                .y(25)
                .direction(Direction.DOWN)
                .build();

        player.move(Direction.UP);

        assertEquals(player.getY(), 24);
    }
}