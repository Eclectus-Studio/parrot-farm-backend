package org.minetrio1256.parrot_farm_backend.world.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;

public abstract class Object {
    private String name;  // Name of the object
    private int width;    // Width in terms of tiles
    private int height;   // Height in terms of tiles
    private JsonObject nbt;
    private Coordinate coordinate;

    // Constructor with name, width, height, and position
    public Object(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    // Getter methods
    public  String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Abstract method to apply NBT data, each object will implement this
    public abstract void applyNBTData(JsonObject nbtData);

    public abstract void tick();

    public JsonElement getNBTData(){
        return nbt;
    }

    public abstract void setCoordinate(Coordinate newCoords);

    public abstract Coordinate getCoordinate();
}
