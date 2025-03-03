package org.minetrio1256.parrot_farm_backend.api.world;

import org.minetrio1256.parrot_farm_backend.world.api.Soil;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;
import org.minetrio1256.parrot_farm_backend.world.levels.Level1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/world")
public class GetWorld {

    @GetMapping("/get/level1")
    public HashMap<Coordinate, Soil> getData() {
        return Level1.Level1Map;
    }
}