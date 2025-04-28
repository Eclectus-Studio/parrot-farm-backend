package org.minetrio1256.parrot_farm_backend.api.tunnels;

import com.google.gson.JsonObject;
import org.minetrio1256.parrot_farm_backend.packets.UpdatePlayerLocationsPacket;
import org.minetrio1256.parrot_farm_backend.token.Tokens;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TunnelWebSocketHandler extends TextWebSocketHandler {
    private static final List<WebSocketSession> activeSessions = new ArrayList<>();
    private static final List<String> approvedId = new ArrayList<>();
    private ScheduledExecutorService scheduler;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("New connection: " + session.getId());
        activeSessions.add(session);  // Add the session to the active sessions set
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receivedText = message.getPayload();
        System.out.println("Received: " + receivedText);
        if(approvedId.contains(session.getId())){
            // Assuming the message is a JSON formatted packet (like movement)
            JsonObject jsonObject = new JsonObject();  // Parse your receivedText into JsonObject (e.g., with Gson)
            if (jsonObject.has("packet-type") && jsonObject.get("packet-type").getAsString().equals("movement")) {
                // Extract movement details and process the movement
                String direction = jsonObject.get("direction").getAsString();
                String playerId = jsonObject.get("playerId").getAsString();

                JsonObject packetInfo = new JsonObject();
                packetInfo.addProperty("playerId", playerId);
                packetInfo.addProperty("direction", direction);

                UpdatePlayerLocationsPacket movementPacket = new UpdatePlayerLocationsPacket(packetInfo);
                movementPacket.run(); // Perform movement logic

                // Optionally, send a response back to the client
                session.sendMessage(new TextMessage("{\"packet-type\":\"movement\",\"status\":\"success\"}"));
            }
        } else {
            JsonObject jsonObject = new JsonObject();
            if(jsonObject.has("packet-type") && jsonObject.get("packet-type").getAsString().equals("auth")){
                String gameToken = jsonObject.get("token").getAsString();
                if(Tokens.isValidToken(gameToken)){
                    startTunnel(session);
                    approvedId.add(session.getId());
                }
            } else {
                session.close(CloseStatus.POLICY_VIOLATION);
            }
        }
    }

    private void startTunnel(WebSocketSession session) {
        scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            try {
                for (int i = 1; i <= 4; i++) {
                    session.sendMessage(new TextMessage(String.valueOf(i)));
                    Thread.sleep(1000); // 1 sec delay
                }
            } catch (IOException | InterruptedException e) {
                stopTunnel();
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    private void stopTunnel() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        System.out.println("Connection closed: " + session.getId());
        activeSessions.remove(session);  // Remove the session when closed
        stopTunnel();
    }

    // A static method to get all active sessions
    public static List<WebSocketSession> getActiveSessions() {
        return activeSessions;
    }
}

