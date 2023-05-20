package com.example.s2;

import com.example.s2.game.Direction;
import com.example.s2.game.Player;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class check_zero {

    // check if the object starts from 0,0

    @Test
    public void testPlayerStartsAtZero() {
        Player player = new Player.Builder()
                .x(0)
                .y(0)
                .direction(Direction.UP)
                .build();
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }

}

