package org.minetrio1256.parrot_farm_backend.packets;

import com.google.gson.JsonObject;

public class UpdateObjectPacket extends Packet{
    public UpdateObjectPacket(String name, JsonObject info) {
        super(name, info);
    }

    @Override
    public void run() {

    }
}
