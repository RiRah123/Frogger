package com.example.s2;

import static org.junit.Assert.assertEquals;

import com.example.s2.game.Vehicle;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
    private Vehicle vehicle;

    @Before
    public void setUp() {
        float xPos = 0;
        float yPos = 0;
        float speed = 1;
        Vehicle.VehicleType vehicleType = Vehicle.VehicleType.CAR;
        vehicle = new Vehicle(xPos, yPos, speed, vehicleType) {
            @Override
            public void updatePosition() {
                // do nothing
            }
        };
    }

    @Test
    public void testGetSpeed() {
        float expectedSpeed = 1;
        assertEquals(expectedSpeed, vehicle.getSpeed(), 0.0f);
    }

    @Test
    public void testVehicleType() {
        Vehicle.VehicleType expected = Vehicle.VehicleType.CAR;
        assertEquals(expected, vehicle.getVehicleType());
    }
}