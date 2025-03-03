package org.minetrio1256.parrot_farm_backend.world.loader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import org.minetrio1256.parrot_farm_backend.world.api.Soil;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;
import org.minetrio1256.parrot_farm_backend.world.api.world.SoilsList;
import org.minetrio1256.parrot_farm_backend.world.levels.Level1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadLevel1 {

    public void loadLevel1() {
        SoilsList soilsList = new SoilsList();
        Gson gson = new Gson();
        String filePath = "./world/level1.json";

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        try (FileReader reader = new FileReader(file)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            System.out.println("Loaded JSON: " + jsonObject.toString());

            if (jsonObject.has("soils")) {
                JsonObject soils = jsonObject.getAsJsonObject("soils");
                System.out.println("Found soils");
                for (int i = 0; i < 2; i++) {
                    Soil soil = soilsList.getSoil(i);
                    System.out.println("In load soil loop");
                    String soilName = soil.getName();
                    if (soils.has(soilName)) {
                        System.out.println("found grass");
                        JsonObject soilType = soils.getAsJsonObject(soilName);
                        Soil currentSoil = new Soil(soilName);
                        for (String xKey : soilType.keySet()) {
                            try {
                                int x = Integer.parseInt(xKey);
                                JsonObject soilData = soilType.getAsJsonObject(xKey);
                                int y = soilData.get("y").getAsInt();
                                JsonElement nbt = soilData.get("nbt");
                                currentSoil.applyNBTData(nbt.getAsJsonObject());
                                Coordinate coords = new Coordinate(x,y);
                                Level1 level1 = new Level1();
                                System.out.println("added "+ currentSoil.getName()+" at "+ coords.getX()+","+coords.getY());
                                level1.setSoilAt(coords,currentSoil);

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
