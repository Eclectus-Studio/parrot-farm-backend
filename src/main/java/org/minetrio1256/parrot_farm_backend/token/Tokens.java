package org.minetrio1256.parrot_farm_backend.token;

import java.util.ArrayList;

public class Tokens {
    private static ArrayList<String> tokens = new ArrayList<>();

    public static void addToken(String token){
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
}
