package org.minetrio1256.parrot_farm_backend.token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class Tokens {
    private static ArrayList<String> tokens = new ArrayList<>();
    private static HashMap<String, UUID> PlayersUUID = new HashMap<>();

    public static void addToken(String token, UUID uuid){
        tokens.add(token);
    }

    public static boolean isValidToken(String token) {
        for (int i  = 0; i < tokens.size(); i++){
            if(tokens.get(i).equals(token)){
                return true;
            }
        }
        return false;
    }

    public static void removeToken(String token) {
        for (int i  = 0; i < tokens.size(); i++){
            if(tokens.get(i).equals(token)){
                tokens.remove(i);
            }
        }
    }

    public static UUID getUUIDfromToken(String token){
        return PlayersUUID.get(token);
    }

    public static void removeUUID(UUID uuid){
        Set<String> tokens = PlayersUUID.keySet();
        for(String token : tokens){
            if(PlayersUUID.get(token) == uuid){
                PlayersUUID.remove(token);
            }
        }
    }
}
