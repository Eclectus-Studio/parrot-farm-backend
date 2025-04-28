package org.minetrio1256.parrot_farm_backend.packets;

import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.api.tunnels.TunnelWebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;

import java.util.List;

public class UpdatePlayerLocationsPacket extends Packet {

    private String playerId;
    private String direction;

    public UpdatePlayerLocationsPacket(JsonObject info) {
        super("update_player_location", info);
        this.playerId = info.get("playerId").getAsString();
        this.direction = info.get("direction").getAsString();
    }

    @Override
    public void run() {
        // Broadcast the movement to all players (or a subset of players)
        List<WebSocketSession> sessions = TunnelWebSocketHandler.getActiveSessions();  // This assumes you have a way to get active sessions
        JsonObject response = new JsonObject();
        response.addProperty("packet-type", "movement");
        response.addProperty("playerId", playerId);
        response.addProperty("direction", direction);

        for (WebSocketSession session : sessions) {
            try {
                // Send movement update to each connected client
                session.sendMessage(new TextMessage(response.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getDirection() {
        return direction;
    }
}
