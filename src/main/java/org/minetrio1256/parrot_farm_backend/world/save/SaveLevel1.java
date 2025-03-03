package org.minetrio1256.parrot_farm_backend.world.save;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.world.api.Soil;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;
import org.minetrio1256.parrot_farm_backend.world.levels.Level1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLevel1 {

    public void saveLevel1(Level1 level1) {
        Gson gson = new Gson();
        String filePath = "./world/level1.json";
        JsonObject jsonObject = new JsonObject();
        JsonObject soilsObject = new JsonObject();

        for (Coordinate coord : level1.getLevel1Map().keySet()) {
            Soil soil = level1.getLevel1Map().get(coord);
            String soilName = soil.getName();

            JsonObject soilType = soilsObject.has(soilName) ? soilsObject.getAsJsonObject(soilName) : new JsonObject();
            JsonObject soilData = new JsonObject();

            soilData.addProperty("y", coord.getY());
            JsonElement nbt = soil.getNBTData();
            soilData.add("nbt", nbt);
            soilType.add(String.valueOf(coord.getX()), soilData);

            soilsObject.add(soilName, soilType);
        }

        jsonObject.add("soils", soilsObject);

        try (FileWriter writer = new FileWriter(new File(filePath))) {
            gson.toJson(jsonObject, writer);
            System.out.println("Level 1 saved successfully to " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving level 1: " + e.getMessage());
        }
    }
}
