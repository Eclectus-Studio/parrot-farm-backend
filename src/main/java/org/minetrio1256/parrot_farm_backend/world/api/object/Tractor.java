package org.minetrio1256.parrot_farm_backend.world.api.object;

import org.minetrio1256.parrot_farm_backend.world.api.Object;
import com.google.gson.JsonObject;

public class Tractor extends Object {
    private int speed;  // Speed of the tractor
    private boolean isOperational;  // Whether the tractor is operational or not

    // Constructor for Tractor (1x2 tiles)
    public Tractor(int x, int y) {
        super("Tractor", 1, 2, x, y);  // Tractor occupies 1x2 tiles
        this.speed = 6;  // Default speed
        this.isOperational = true;  // Tractor is operational by default
    }

    // Apply NBT data to the Tractor object
    @Override
    public void applyNBTData(JsonObject nbtData) {
        if (nbtData.has("speed")) {
            this.speed = nbtData.get("speed").getAsInt();
        }
        if (nbtData.has("operational")) {
            this.isOperational = nbtData.get("operational").getAsBoolean();
        }
    }

    // Getter methods for tractor-specific properties
    public int getSpeed() {
        return speed;
    }

    public boolean isOperational() {
        return isOperational;
    }

    @Override
    public String toString() {
        return String.format("%s (Position: [%d, %d], Size: %dx%d, Speed: %d, Operational: %b)",
                getName(), getX(), getY(), getWidth(), getHeight(), speed, isOperational);
    }
}
