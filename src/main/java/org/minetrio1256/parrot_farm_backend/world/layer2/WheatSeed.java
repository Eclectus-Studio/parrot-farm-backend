package org.minetrio1256.parrot_farm_backend.world.layer2;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.world.api.Object;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;
import org.minetrio1256.parrot_farm_backend.world.levels.Level2;

public class WheatSeed extends Object {
    private String name;        // Name of the object
    private int width;          // Width in terms of tiles
    private int height;         // Height in terms of tiles
    private JsonObject nbt;
    private int growth = 0;
    private Coordinate coordinate;

    // Constructor with name, width, height, and position
    public WheatSeed() {
        super("WheatObject-seed", 1,1);
        this.height = 1;
        this.width = 1;
        this.name = "WheatObject";
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
        if (nbtData.has("growth")) {
            this.growth = nbtData.get("growth").getAsInt();
        }
    }

    @Override
    public void tick(){
        if(!isGrowthFinished()){
            addGrowth();
        } else {
            Level2.setObjectAt(coordinate, new WheatObject());
        }
    }

    @Override
    public JsonElement getNBTData(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("growth", growth);
        return jsonObject;
    }

    private boolean isGrowthFinished() {
        if(growth == 200){
            return true;
        }
        return false;
    }

    private void addGrowth(){
        growth++;
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
