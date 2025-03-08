package org.minetrio1256.parrot_farm_backend.items;

import java.util.HashMap;

public class RegisterItem {
    public static HashMap<Integer, Item> Items = new HashMap<>();
    public static int currentid = -1;

    public static void registerItem(Item Item) {
        currentid++;
        Item newItem = Item;
        Items.put(currentid,newItem);
        System.out.println("Added "+ Item.getName());
    }

    public static Item getItem(int i) {
        return Items.get(i);
    }

    public static HashMap<Integer, Item> getItems() {
        return Items;
    }

    public static int getLength(){
        return currentid + 1;
    }

    public static String getName(int index){
        return Items.get(index).getName();
    }
}
