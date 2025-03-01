package org.minetrio1256.parrot_farm_backend.world.api;

import org.minetrio1256.parrot_farm_backend.world.api.Object;

public class Player {
    private String name;
    private int x, y;             // Position on the map (tile coordinates)
    private int health;           // Health of the player (optional)
    private int speed;            // Speed of the player (tiles per second)
    private String currentAction; // Current action (planting, harvesting, etc.)
    private Farm farm;            // Reference to the shared farm (holds coins and farm data)

    // Constructor to initialize the player
    public Player(String name, int x, int y, int health, int speed, Farm farm) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.health = health;
        this.speed = speed;
        this.farm = farm;
        this.currentAction = "Idle"; // Default action
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(String currentAction) {
        this.currentAction = currentAction;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    // Method to move the player based on their speed
    public void move(int dx, int dy) {
        this.x += dx * speed;
        this.y += dy * speed;
        System.out.println(name + " moved to position (" + x + ", " + y + ")");
    }

    // Method to interact with the farm
    public void interactWithFarm() {
        System.out.println(name + " is interacting with the farm.");
        System.out.println("Farm name: " + farm.getFarmName());
        System.out.println("Farm coins: " + farm.getCoins());
        // Further interaction logic can be added here, e.g., adding coins to the farm, etc.
    }

    // Apply NBT data for the player (if necessary)
    public void applyNBTData() {
        System.out.println("Applying NBT data for player: " + name);
        // Further logic for saving player-specific state could go here
    }
}

