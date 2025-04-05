package org.minetrio1256.parrot_farm_backend.world.api;

import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;

import java.util.UUID;

public class Player {
    private String name;
    private Coordinate coords;             // Position on the map (tile coordinates)
    private int health;           // Health of the player (optional)
    private int speed;            // Speed of the player (tiles per second)
    private String currentAction; // Current action (planting, harvesting, etc.)
    private Farm farm;            // Reference to the shared farm (holds coins and farm data)
    private UUID uuid;            // User Unique Id

    // Constructor to initialize the player
    public Player(String name, int x, int y, int health, int speed, Farm farm, UUID uuid) {
        this.name = name;
        this.coords.setX(x);
        this.coords.setY(y);
        this.health = health;
        this.speed = speed;
        this.farm = farm;
        this.currentAction = "Idle"; // Default action
        this.uuid = uuid;
    }

    // Getters and setters
    public UUID getUuid(){
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return coords.getX();
    }

    public void setX(int x) {
        this.coords.setX(x);
    }

    public int getY() {
        return coords.getY();
    }

    public void setY(int y) {
        this.coords.setY(y);
    }

    public Coordinate getCoordinate(){
        return coords;
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

