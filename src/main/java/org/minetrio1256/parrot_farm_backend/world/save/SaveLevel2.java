package org.minetrio1256.parrot_farm_backend.world.save;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.world.api.Object;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;
import org.minetrio1256.parrot_farm_backend.world.levels.Level2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLevel2 {
    public static void saveLevel2() {
        Gson gson = new Gson();
        String filePath = "./world/level2.json";
        JsonObject jsonObject = new JsonObject();
        JsonObject objectsObject = new JsonObject();

        for (Coordinate coord : Level2.getLevel2Map().keySet()) {
            Object object = Level2.getLevel2Map().get(coord);
            String objectName = object.getName();

            JsonObject objectType = objectsObject.has(objectName) ? objectsObject.getAsJsonObject(objectName) : new JsonObject();
            JsonObject objectData = new JsonObject();

            objectData.addProperty("y", coord.getY());
            JsonElement nbt = object.getNBTData();
            objectData.add("nbt", nbt);
            objectType.add(String.valueOf(coord.getX()), objectData);

            objectsObject.add(objectName, objectType);
        }

        jsonObject.add("objects", objectsObject);

        try (FileWriter writer = new FileWriter(new File(filePath))) {
            gson.toJson(jsonObject, writer);
            System.out.println("Level 2 saved successfully to " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving level 2: " + e.getMessage());
        }
    }
}
