package org.minetrio1256.parrot_farm_backend.config;

import org.minetrio1256.parrot_farm_backend.api.tunnels.TunnelWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new TunnelWebSocketHandler(), "/tunnel").setAllowedOrigins("*");
    }
}

