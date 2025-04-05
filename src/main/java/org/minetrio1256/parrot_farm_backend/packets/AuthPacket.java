package org.minetrio1256.parrot_farm_backend.packets;

import com.google.gson.JsonObject;

public class AuthPacket extends Packet{
    public AuthPacket(JsonObject info) {
        super(info);
    }

    @Override
    public void run() {

    }
}
