package org.minetrio1256.parrot_farm_backend.packets;


import java.util.HashMap;

public class PacketRegistry  {
    private static HashMap<String, Packet> packets = new HashMap<>();

    public static void addPacket(String id, Packet packet){
        packets.put(id,packet);
    }
}
