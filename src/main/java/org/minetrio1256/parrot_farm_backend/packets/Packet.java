package org.minetrio1256.parrot_farm_backend.packets;

import com.google.gson.JsonObject;

public abstract class Packet {
    private JsonObject info;

    public Packet(JsonObject info){
        this.info = info;
    }

    public JsonObject getInfo() {
        return info;
    }

    public abstract void run();
}
