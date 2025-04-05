package org.minetrio1256.parrot_farm_backend.packets;

import com.google.gson.JsonObject;

public class EnteredVehiclePacket extends Packet{
    public EnteredVehiclePacket(JsonObject info) {
        super(info);
    }

    @Override
    public void run() {

    }
}
