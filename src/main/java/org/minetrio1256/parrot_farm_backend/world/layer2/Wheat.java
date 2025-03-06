package org.minetrio1256.parrot_farm_backend.world.layer2;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.world.api.Object;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;

public class Wheat extends Object {
    private String name;        // Name of the object
    private int width;          // Width in terms of tiles
    private int height;         // Height in terms of tiles
    private JsonObject nbt;
    private Coordinate coordinate;

    // Constructor with name, width, height, and position
    public Wheat() {
        super("wheat", 1,1);
        this.height = 1;
        this.width = 1;
        this.name = "wheat";
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

    @Override
    public void applyNBTData(JsonObject nbtData) {
        nbt = nbtData;
    }

    @Override
    public void tick(){

    }

    @Override
    public JsonElement getNBTData(){
        return nbt;
    }

    @Override
    public void setCoordinate(Coordinate newCoords) {
        coordinate = newCoords;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
