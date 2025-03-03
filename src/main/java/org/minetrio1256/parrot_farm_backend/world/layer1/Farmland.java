package org.minetrio1256.parrot_farm_backend.world.layer1;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.world.api.Soil;

public class Farmland extends Soil {
    private boolean isHydrated;  // Hydration status of the soil
    private boolean isFertilized;
    private JsonObject nbt;

    // Constructor with name initialization
    public Farmland() {
        super("Farmland");  // Set name to "Farmland"
        this.isHydrated = false;  // Default hydration status
        this.isFertilized = false;
    }

    // Implement the applyNBTData method to handle hydration and other NBT data
    @Override
    public void applyNBTData(JsonObject nbtData) {
        nbt = nbtData;
        if (nbtData.has("hydration")) {
            this.isHydrated = nbtData.get("hydration").getAsBoolean();
        }
        if(nbtData.has("fertilized")) {
            this.isFertilized = nbtData.get("fertilized").getAsBoolean();
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
