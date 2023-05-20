package com.example.s2.game;

import com.example.s2.R;

public abstract class Vehicle {
    private float speed;
    private float xPosition;
    private final float yPosition;
    private int width;
    private int impact;
    private VehicleType vehicleType;

    public enum VehicleType {
        TRUCK(R.drawable.vehicle1),
        CAR(R.drawable.vehicle2),
        RACECAR(R.drawable.vehicle3);

        private final int vehicleID;

        VehicleType(int vehicleID) {
            this.vehicleID = vehicleID;
        }

        public int getVehicleID() {
            return vehicleID;
        }
    }

    public Vehicle(float xPosition, float yPosition, float speed, VehicleType vehicleType) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.speed = speed;
        this.vehicleType = vehicleType;
    }

    public abstract void updatePosition();

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getXPosition() {
        return xPosition;
    }

    public void setXPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getYPosition() {
        return yPosition;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getImpact() {
        return impact;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}