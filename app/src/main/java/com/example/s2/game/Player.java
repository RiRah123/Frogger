package com.example.s2.game;

public class Player {
    private int x;
    private int y;
    private Direction direction;

    private Player(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.direction = builder.direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(Direction direction) {
        Tile currentTile = getTile(x, y);
        Tile nextTile = getTile(x + direction.getDx(), y + direction.getDy());

        // check for collisions with vehicles/logless rivers in future
        // based on current and next tiles

        x += direction.getDx();
        y += direction.getDy();
        this.direction = direction;
    }

    private Tile getTile(int x, int y) {
        // retrieve tile at given coords
        return null;
    }

    public static class Builder {
        private int x;
        private int y;
        private Direction direction;

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public Builder y(int y) {
            this.y = y;
            return this;
        }

        public Builder direction(Direction direction) {
            this.direction = direction;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}