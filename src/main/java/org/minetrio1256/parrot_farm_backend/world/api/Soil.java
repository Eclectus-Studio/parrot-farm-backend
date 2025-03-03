package org.minetrio1256.parrot_farm_backend.world.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Soil {
    private String name = "";  // Name of the soil type
    private JsonObject nbt;

    // Constructor to initialize the soil with a name
    public Soil(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract method to be implemented by subclasses to apply NBT data
    public void applyNBTData(JsonObject nbtData) {
        nbt = nbtData;
    }

    public JsonElement getNBTData(){
        return nbt;
    }
}
