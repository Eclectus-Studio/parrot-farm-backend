package org.minetrio1256.parrot_farm_backend.world.layer2;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.items.Item;
import org.minetrio1256.parrot_farm_backend.items.inventory.Inventory;
import org.minetrio1256.parrot_farm_backend.world.api.Object;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;

public class Silo extends Object {
    private String name;        // Name of the object
    private int width;          // Width in terms of tiles
    private int height;         // Height in terms of tiles
    private JsonObject nbt;
    public Coordinate coordinate;
    private int maxInventoryCapacity;
    private Inventory inventory = new Inventory(maxInventoryCapacity);

    // Constructor with name, width, height, and position
    public Silo() {
        super("silo", 2,2);
        this.height = 1;
        this.width = 1;
        this.name = "wheat";
        this.maxInventoryCapacity = 400;
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

    public int getMaxInventoryCapacity() {
        return maxInventoryCapacity;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean insertItem(Item item, int amount){
        if(inventory.addItem(item, amount)){
            return true;
        } else {
            return false;
        }
    }

    public int currentItemAmount(){
        return inventory.getCurrentItemAmount();
    }

    public static class Silo2 extends Object{
        private Coordinate coordinate;

        public Silo2() {
            super("silo2", 1, 1);
        }

        @Override
        public void applyNBTData(JsonObject nbtData) {
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
    }
    public static class Silo3 extends Object{
        private Coordinate coordinate;

        public Silo3() {
            super("silo3", 1, 1);
        }

        @Override
        public void applyNBTData(JsonObject nbtData) {
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
    }
    public static class Silo4 extends Object{
        private Coordinate coordinate;

        public Silo4() {
            super("silo4", 1, 1);
        }

        @Override
        public void applyNBTData(JsonObject nbtData) {
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
    }
}