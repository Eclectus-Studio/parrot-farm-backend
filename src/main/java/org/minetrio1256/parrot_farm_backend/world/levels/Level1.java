package org.minetrio1256.parrot_farm_backend.world.levels;

import org.minetrio1256.parrot_farm_backend.world.api.Soil;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;

import java.util.HashMap;

public class Level1 {
    public static final HashMap<Coordinate, Soil> Level1Map = new HashMap<>();

    public Level1(){

    }

    public HashMap<Coordinate, Soil> getLevel1Map(){
        return Level1Map;
    }

    public void setSoilAt(Coordinate coordinate, Soil soil){
        Level1Map.put(coordinate, soil);
    }

    public Soil getSoilAt(Coordinate coordinate){
        return Level1Map.get(coordinate);
    }
}
