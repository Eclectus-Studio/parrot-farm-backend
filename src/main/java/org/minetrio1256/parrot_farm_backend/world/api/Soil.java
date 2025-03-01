package org.minetrio1256.parrot_farm_backend.world.api;

import com.google.gson.JsonObject;

public abstract class Soil {
    private String name;  // Name of the soil type

    // Constructor to initialize the soil with a name
    public Soil(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method to be implemented by subclasses to apply NBT data
    public abstract void applyNBTData(JsonObject nbtData);
}
