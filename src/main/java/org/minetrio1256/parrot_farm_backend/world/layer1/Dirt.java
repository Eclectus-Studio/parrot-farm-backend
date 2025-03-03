package org.minetrio1256.parrot_farm_backend.world.layer1;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.world.api.Soil;

public class Dirt extends Soil {
    private boolean isHydrated;  // Hydration status of the soil
    private JsonObject nbt;

    // Constructor with name initialization
    public Dirt() {
        super("Dirt");  // Set name to "Dirt"
        this.isHydrated = false;  // Default hydration status
    }

    // Implement the applyNBTData method to handle hydration and other NBT data
    @Override
    public void applyNBTData(JsonObject nbtData) {
        nbt = nbtData;
        if (nbtData.has("hydration")) {
            this.isHydrated = nbtData.get("hydration").getAsBoolean();
        }
    }

    public boolean isHydrated() {
        return isHydrated;
    }

    @Override
    public JsonElement getNBTData(){
        return nbt;
    }
}
