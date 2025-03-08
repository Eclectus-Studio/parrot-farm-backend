package org.minetrio1256.parrot_farm_backend.api.world;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.world.api.Object;
import org.minetrio1256.parrot_farm_backend.world.api.Soil;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;
import org.minetrio1256.parrot_farm_backend.world.levels.Level1;
import org.minetrio1256.parrot_farm_backend.world.levels.Level2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/world")
public class GetWorld {

    private static final Gson gson = new Gson();

    @GetMapping("/get/level1")
    public Map<String, Object> getDataLevel1() {
        JsonObject jsonObject = new JsonObject();
        JsonObject soilsObject = new JsonObject();

        for (Coordinate coord : Level1.getLevel1Map().keySet()) {
            Soil soil = Level1.getLevel1Map().get(coord);
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

        // Convert JsonObject to Map<String, Object>
        return gson.fromJson(jsonObject, Map.class);
    }

    @GetMapping("/get/level2")
    public Map<String, Object> getDataLevel2() {
        JsonObject jsonObject = new JsonObject();
        JsonObject objectJsonObject = new JsonObject();

        for (Coordinate coord : Level2.getLevel2Map().keySet()) {
            Object object = Level2.getLevel2Map().get(coord);
            String objectName = object.getName();

            JsonObject objectType = objectJsonObject.has(objectName) ? objectJsonObject.getAsJsonObject(objectName) : new JsonObject();
            JsonObject objectData = new JsonObject();

            objectData.addProperty("y", coord.getY());
            JsonElement nbt = object.getNBTData();
            objectData.add("nbt", nbt);
            objectType.add(String.valueOf(coord.getX()), objectData);

            objectJsonObject.add(objectName, objectType);
        }

        jsonObject.add("objects", objectJsonObject);

        // Convert JsonObject to Map<String, Object>
        return gson.fromJson(jsonObject, Map.class);
    }
}
