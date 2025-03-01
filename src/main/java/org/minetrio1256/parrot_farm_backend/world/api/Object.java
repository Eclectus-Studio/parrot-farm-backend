package org.minetrio1256.parrot_farm_backend.world.api;

import com.google.gson.JsonObject;

public abstract class Object {
    private String name;  // Name of the object
    private int width;    // Width in terms of tiles
    private int height;   // Height in terms of tiles
    private int x;        // X-coordinate of the object's position (top-left corner)
    private int y;        // Y-coordinate of the object's position (top-left corner)

    // Constructor with name, width, height, and position
    public Object(String name, int width, int height, int x, int y) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Abstract method to apply NBT data, each object will implement this
    public abstract void applyNBTData(JsonObject nbtData);

    // Method to check if the object fits within the given bounds of the map
    public boolean fitsInBounds(int mapWidth, int mapHeight) {
        return (x + width <= mapWidth) && (y + height <= mapHeight);
    }

    // Override toString to print out the details of the object
    @Override
    public String toString() {
        return String.format("%s (Position: [%d, %d], Size: %dx%d)", name, x, y, width, height);
    }
}
