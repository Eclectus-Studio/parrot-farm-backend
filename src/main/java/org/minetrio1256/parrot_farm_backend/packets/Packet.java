package org.minetrio1256.parrot_farm_backend.packets;

import com.google.gson.JsonObject;

public abstract class Packet {
    private String name;
    private JsonObject info;

    public Packet(String name, JsonObject info){
        this.info = info;
        this.name = name;
    }

    public JsonObject getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }

    public abstract void run();
}
