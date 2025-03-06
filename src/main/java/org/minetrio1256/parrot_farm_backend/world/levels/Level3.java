package org.minetrio1256.parrot_farm_backend.world.levels;

import org.minetrio1256.parrot_farm_backend.world.api.Soil;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;

import java.util.HashMap;

public class Level3 {

    public static final HashMap<Coordinate, Soil> Level3Map = new HashMap<>();

    public static HashMap<Coordinate, Soil> getLevel3Map(){
        return Level3Map;
    }

    public static void setSoilAt(Coordinate coordinate, Soil soil){
        Level3Map.put(coordinate, soil);
    }

    public static Soil getSoilAt(Coordinate coordinate){
        return Level3Map.get(coordinate);
    }
}
