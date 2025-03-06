package org.minetrio1256.parrot_farm_backend.world.levels;

import org.minetrio1256.parrot_farm_backend.world.api.Object;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;

import java.util.HashMap;

public class Level2 {

    public static final HashMap<Coordinate, Object> Level2Map = new HashMap<>();

    public static HashMap<Coordinate, Object> getLevel2Map(){
        return Level2Map;
    }

    public static void setObjectAt(Coordinate coordinate, Object object){
        Level2Map.put(coordinate, object);
    }

    public static Object getObjectAt(Coordinate coordinate){
        return Level2Map.get(coordinate);
    }
}
