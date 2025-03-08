package org.minetrio1256.parrot_farm_backend.items.custom;

import org.minetrio1256.parrot_farm_backend.items.Item;

public class Wheat extends Item {
    private String name;

    public Wheat() {
        super("Wheat");
        this.name = "Wheat";
    }

    @Override
    public String getName(){
        return name;
    }
}
