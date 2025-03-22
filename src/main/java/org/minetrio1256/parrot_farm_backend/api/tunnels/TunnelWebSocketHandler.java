package org.minetrio1256.parrot_farm_backend.api.tunnels;

import org.minetrio1256.parrot_farm_backend.token.Tokens;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TunnelWebSocketHandler extends TextWebSocketHandler {
    private static final List<String> ALLOWED_STRINGS = Arrays.asList("start", "hello", "parrot");
    private ScheduledExecutorService scheduler;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("New connection: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receivedText = message.getPayload();
        System.out.println("Received: " + receivedText);

        if (Tokens.isValidToken(receivedText)) {
            startTunnel(session);
            System.out.println("valid");
        } else {
            session.close(CloseStatus.POLICY_VIOLATION);
            System.out.println("invalid");
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
        stopTunnel();
    }
}

