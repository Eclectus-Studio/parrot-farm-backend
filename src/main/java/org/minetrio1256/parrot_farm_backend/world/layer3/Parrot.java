package org.minetrio1256.parrot_farm_backend.world.layer3;

import org.minetrio1256.parrot_farm_backend.world.api.Farm;
import org.minetrio1256.parrot_farm_backend.world.api.Player;

import java.util.UUID;

public class Parrot extends Player {
    public Parrot(String name, int x, int y, int health, int speed, Farm farm, UUID uuid) {
        super(name, x, y, health, speed, farm, uuid);
    }
    //Nothing here for now
}
