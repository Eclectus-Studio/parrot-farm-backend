package org.minetrio1256.parrot_farm_backend.world.loader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import org.minetrio1256.parrot_farm_backend.world.api.Object;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;
import org.minetrio1256.parrot_farm_backend.world.api.world.ObjectList;
import org.minetrio1256.parrot_farm_backend.world.levels.Level2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadLevel2 {

    public void loadLevel2() {
        Gson gson = new Gson();
        String filePath = "./world/level2.json";

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        try (FileReader reader = new FileReader(file)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            System.out.println("Loaded JSON: " + jsonObject.toString());

            if (jsonObject.has("objects")) {
                JsonObject objects = jsonObject.getAsJsonObject("objects");
                System.out.println("Found objects");
                for (int i = 0; i < ObjectList.getLength(); i++) {
                    Object object = ObjectList.getObject(i);
                    System.out.println("In load object loop");
                    String objectName = object.getName();
                    if (objects.has(objectName)) {
                        System.out.println("Found a valid object");
                        JsonObject objectType = objects.getAsJsonObject(objectName);
                        Object currentObject = ObjectList.getObject(i);
                        for (String xKey : objectType.keySet()) {
                            try {
                                int x = Integer.parseInt(xKey);
                                JsonObject objectData = objectType.getAsJsonObject(xKey);
                                int y = objectData.get("y").getAsInt();
                                JsonElement nbt = objectData.get("nbt");
                                currentObject.applyNBTData(nbt.getAsJsonObject());
                                Coordinate coords = new Coordinate(x, y);
                                currentObject.setCoordinate(coords);
                                System.out.println("Added " + currentObject.getName() + " at " + coords.getX() + "," + coords.getY());
                                Level2.setObjectAt(coords, currentObject);

                            } catch (NumberFormatException e) {
                                System.err.println("Invalid x value: " + xKey);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (JsonSyntaxException e) {
            System.err.println("Invalid JSON format: " + e.getMessage());
        }
    }
}
