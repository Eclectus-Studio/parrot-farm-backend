package org.minetrio1256.parrot_farm_backend.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleCommandListener implements Runnable {
    private boolean running = true;

    public void startListening() {
        Thread thread = new Thread(this);
        thread.start(); // Start the listener in a new thread
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (running && scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            processCommand(input);
        }

        scanner.close();
    }

    private void processCommand(String input) {
        int length = RegisterCommands.getLength();

        if (input.startsWith("/")) {
            String[] parts = input.substring(1).split(" ");
            String command = parts[0];
            List<String> argsList = new ArrayList<>(Arrays.asList(parts).subList(1, parts.length));

            for (int i = 0; i < length; i++) {
                Command commandById = RegisterCommands.getCommandById(i);
                String commandName = commandById.getName();
                String commadnInputName = command;
                if (commadnInputName.equals(commandName)) {
                    Command commandToRun = RegisterCommands.getCommandById(i);
                    commandToRun.run(argsList);
                }
            }
        } else {
            System.out.println("Invalid command format. Please use /help to get the list of command or /help (command-name) to get their arguments!");
        }
    }
}
