package org.minetrio1256.parrot_farm_backend.world.api.object;

import org.minetrio1256.parrot_farm_backend.world.api.Object;
import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;

public class Tractor extends Object {
    private int speed;  // Speed of the tractor
    private boolean isOperational;  // Whether the tractor is operational or not
    private String name;  // Name of the object
    private int width;    // Width in terms of tiles
    private int height;   // Height in terms of tiles
    private JsonObject nbt;
    private Coordinate coordinate;

    // Constructor for Tractor (1x2 tiles)
    public Tractor() {
        super("Tractor", 1, 2);  // Tractor occupies 1x2 tiles
        this.speed = 6;  // Default speed
        this.isOperational = true;  // Tractor is operational by default
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
}
