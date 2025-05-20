package org.minetrio1256.parrot_farm_backend.world.api.world;

import org.minetrio1256.parrot_farm_backend.world.api.object.Vehicle;

import java.util.HashMap;

public class VehicleList {
    public static HashMap<Integer, Vehicle> vehicles = new HashMap<>();
    public static int currentid = -1;

    public static void registerVehicle(Vehicle object, String name) {
        currentid++;
        vehicles.put(currentid,object);
        System.out.println("Added "+ object.getName());
    }

    public static Vehicle getVehicle(int i) {
        return vehicles.get(i);
    }

    public static HashMap<Integer, Vehicle> getVehicles() {
        return vehicles;
    }

    public static int getLength(){
        return currentid + 1;
    }

    public static String getName(int index){
        return vehicles.get(index).getName();
    }
}
