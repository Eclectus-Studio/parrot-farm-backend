package org.minetrio1256.parrot_farm_backend.world.api.object;

import org.minetrio1256.parrot_farm_backend.world.api.Object;
import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;

public abstract class Tractor extends Vehicle {
    private int speed;  // Speed of the tractor
    private boolean isOperational;  // Whether the tractor is operational or not
    private String name;  // Name of the object
    private int width;    // Width in terms of tiles
    private int height;   // Height in terms of tiles
    private JsonObject nbt;
    private Coordinate coordinate;
    private int maxFuel;
    private int fuelLevel;

    // Constructor for Tractor (1x2 tiles)
    public Tractor(boolean isOperational, int maxFuel) {
        super("tractor", 1, 2, 8, isOperational, maxFuel);  // Tractor occupies 1x2 tiles
        this.speed = speed;  // Default speed
        this.isOperational = isOperational;
        this.fuelLevel = fuelLevel;
        this.height = 2;
        this.width = 1;
        this.name = "tractor";
        this.maxFuel = maxFuel;
    }

    // Apply NBT data to the Tractor object
    @Override
    public void applyNBTData(JsonObject nbtData) {
        if (nbtData.has("operational")) {
            this.isOperational = nbtData.get("operational").getAsBoolean();
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void setCoordinate(Coordinate newCoords) {
        coordinate = newCoords;
    }

    @Override
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
}
