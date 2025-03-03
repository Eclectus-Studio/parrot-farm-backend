package org.minetrio1256.parrot_farm_backend.world.api.world;

import org.minetrio1256.parrot_farm_backend.world.api.Soil;

import java.util.HashMap;

public class SoilsList {
    public HashMap<Integer, Soil> soils = new HashMap<>();
    public int currentid = -1;

    public void registerSoil(Soil soil, String name) {
        currentid++;
        Soil newSoil = soil;
        newSoil.setName(name);
        soils.put(currentid,newSoil);
        System.out.println("Added "+ soil.getName());
    }

    public Soil getSoil(int i) {
        return soils.get(i);
    }

    public HashMap<Integer, Soil> getSoils() {
        return soils;
    }

    public int getLength(){
        return currentid + 1;
    }

    public String getName(int index){
        return soils.get(index).getName();
    }
}
