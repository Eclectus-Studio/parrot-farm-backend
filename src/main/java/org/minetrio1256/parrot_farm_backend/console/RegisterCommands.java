package org.minetrio1256.parrot_farm_backend.console;

import java.util.HashMap;

public class RegisterCommands {
    public static HashMap<Integer, Command> RegisteredCommands = new HashMap<>();
    private static int currentId = -1;

    public RegisterCommands() {

    }

    public static void registerCommand(Command command) {
        currentId++;
        RegisteredCommands.put(currentId, command);
    }

    public static Command getCommandById(int i){
        return RegisteredCommands.get(i);
    }

    public static int getLength() {
        return currentId + 1;
    }
}
