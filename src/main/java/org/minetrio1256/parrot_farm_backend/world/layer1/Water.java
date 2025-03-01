package org.minetrio1256.parrot_farm_backend.world.layer1;

import org.minetrio1256.parrot_farm_backend.world.api.Soil;
import com.google.gson.JsonObject;

public class Water extends Soil {
    private boolean isHydrated;  // Hydration status of the water soil (always true for water)

    // Constructor with name initialization
    public Water() {
        super("Water");  // Set name to "Water"
        this.isHydrated = true;  // Water is always hydrated by default
    }

    // Implement the applyNBTData method to handle hydration and other NBT data
    @Override
    public void applyNBTData(JsonObject nbtData) {
        if (nbtData.has("hydration")) {
            this.isHydrated = nbtData.get("hydration").getAsBoolean();
        }
    }

    public boolean isHydrated() {
        return isHydrated;
    }
}
