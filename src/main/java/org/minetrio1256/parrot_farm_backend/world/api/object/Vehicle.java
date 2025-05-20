package org.minetrio1256.parrot_farm_backend.world.api.object;

import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;

public class Vehicle {
    private int speed;  // Speed of the tractor
    private boolean isOperational;  // Whether the tractor is operational or not
    private String name;  // Name of the object
    private int width;    // Width in terms of tiles
    private int height;   // Height in terms of tiles
    private JsonObject nbt;
    private Coordinate coordinate;
    private int maxFuel;
    private int fuelLevel;

    // Constructor for Vehicle
    public Vehicle(String name, int width, int height, int speed, boolean isOperational, int maxFuel) {
        this.speed = speed;  // Default speed
        this.isOperational = isOperational;
        this.fuelLevel = fuelLevel;
        this.width = width;
        this.name = name;
        this.height = height;
        this.maxFuel = maxFuel;
    }

    // Apply NBT data to the Tractor object
    public void applyNBTData(JsonObject nbtData) {
        if (nbtData.has("operational")) {
            this.isOperational = nbtData.get("operational").getAsBoolean();
        }
    }

    public void tick() {

    }

    public void setCoordinate(Coordinate newCoords) {
        coordinate = newCoords;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    // Getter methods for tractor-specific properties
    public int getSpeed() {
        return speed;
    }

    public boolean isOperational() {
        return isOperational;
    }

    public void removeFuel(){
        int i = fuelLevel - 1;
        fuelLevel = 1;
    }

    public String getName() {
        return name;
    }
}
