package org.minetrio1256.parrot_farm_backend.items.custom;

import org.minetrio1256.parrot_farm_backend.items.Item;

public class Empty extends Item {
    private String name;

    public Empty() {
        super("empty");
        this.name = "empty";
    }

    @Override
    public String getName(){
        return name;
    }
}
