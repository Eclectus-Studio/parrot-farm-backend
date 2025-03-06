package org.minetrio1256.parrot_farm_backend.world.api.world;

import org.minetrio1256.parrot_farm_backend.world.api.Object;

import java.util.HashMap;

public class ObjectList {
    public static HashMap<Integer, Object> objects = new HashMap<>();
    public static int currentid = -1;

    public static void registerObject(Object object, String name) {
        currentid++;
        objects.put(currentid,object);
        System.out.println("Added "+ object.getName());
    }

    public static Object getObject(int i) {
        return objects.get(i);
    }

    public static HashMap<Integer, Object> getObjects() {
        return objects;
    }

    public static int getLength(){
        return currentid + 1;
    }

    public static String getName(int index){
        return objects.get(index).getName();
    }
}
