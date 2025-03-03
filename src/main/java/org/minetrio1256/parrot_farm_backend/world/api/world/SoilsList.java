package org.minetrio1256.parrot_farm_backend.world.api.world;

import org.minetrio1256.parrot_farm_backend.world.api.Soil;

import java.util.HashMap;

public class SoilsList {
    public static HashMap<Integer, Soil> soils = new HashMap<>();
    public static int currentid = -1;

    public static void registerSoil(Soil soil, String name) {
        currentid++;
        Soil newSoil = soil;
        newSoil.setName(name);
        soils.put(currentid,newSoil);
        System.out.println("Added "+ soil.getName());
    }

    public static Soil getSoil(int i) {
        return soils.get(i);
    }

    public static HashMap<Integer, Soil> getSoils() {
        return soils;
    }

    public static int getLength(){
        return currentid + 1;
    }

    public static String getName(int index){
        return soils.get(index).getName();
    }
}
