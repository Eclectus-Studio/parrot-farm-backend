package org.minetrio1256.parrot_farm_backend.world.levels;

import org.minetrio1256.parrot_farm_backend.world.api.object.Vehicle;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;

import java.util.HashMap;

public class Level3 {

    public static final HashMap<Coordinate, Vehicle> Level3Map = new HashMap<>();

    public static HashMap<Coordinate, Vehicle> getLevel3Map(){
        return Level3Map;
    }

    public static void setVehicleAt(Coordinate coordinate, Vehicle vehicle){
        Level3Map.put(coordinate, vehicle);
    }

    public static Vehicle getVehicleAt(Coordinate coordinate){
        return Level3Map.get(coordinate);
    }
}
