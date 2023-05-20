package com.example.s2.game;

public class GameInfo {
    private int selectedId;
    private String name;
    private String difficulty;
    private String livesLeft;
    private int points;

    public GameInfo(int selectedId, String name, String difficulty, String livesLeft, int points) {
        this.selectedId = selectedId;
        this.name = name;
        this.difficulty = difficulty;
        this.livesLeft = livesLeft;
        this.points = points;
    }

    public int getSelectedId() {
        return selectedId;
    }

    public String getName() {
        return name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getLivesLeft() {
        return livesLeft;
    }

    public int getPoints() {
        return points;
    }
}
