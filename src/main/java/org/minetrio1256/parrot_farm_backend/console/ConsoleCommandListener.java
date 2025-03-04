package org.minetrio1256.parrot_farm_backend.console;

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
        System.out.println("Console command listener started. Type 'exit' to stop.");

        while (running && scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            processCommand(input);
        }

        scanner.close();
    }

    private void processCommand(String command) {
        switch (command.toLowerCase()) {
            case "hello":
                System.out.println("Hello, world!");
                break;
            case "time":
                System.out.println("Current time: " + java.time.LocalTime.now());
                break;
            case "exit":
                System.out.println("Stopping command listener...");
                running = false;
                break;
            default:
                System.out.println("Unknown command: " + command);
                break;
        }
    }
}
