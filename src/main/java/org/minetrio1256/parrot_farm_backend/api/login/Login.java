package org.minetrio1256.parrot_farm_backend.api.login;

import org.minetrio1256.parrot_farm_backend.token.Tokens;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class Login {
    private static final String VALIDATION_URL = "https://parrot-farm-account-backend.onrender.com/api/validategametoken";

    @PostMapping("/validate")
    public ResponseEntity<Map<String, String>> validateToken(@RequestParam String gameToken, @RequestParam String uuid) {
        try {
            // Prepare request payload (Fix: Use "gameToken" instead of "token")
            Map<String, String> requestPayload = new HashMap<>();
            requestPayload.put("gameToken", gameToken);
            requestPayload.put("uuid", uuid);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(requestPayload);

            // Make HTTP POST request
            URL url = new URL(VALIDATION_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonPayload.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Read the response
            int responseCode = connection.getResponseCode();
            String responseBody = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

            System.out.println("🔍 Response from validategametoken: " + responseBody); // DEBUGGING

            // Parse response
            Map<String, Object> responseMap = objectMapper.readValue(responseBody, HashMap.class);

            if (responseMap.containsKey("error")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid token"));
            }

            // Generate and return a random string
            String randomString = generateRandomString(32);
            UUID accountUUID = UUID.fromString(uuid);
            Tokens.addToken(randomString, accountUUID);

            // Make sure the response contains randomString as expected by the client
            Map<String, String> response = new HashMap<>();
            response.put("randomString", randomString);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Internal server error"));
        }
    }


    private String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes).substring(0, length);
    }
}
