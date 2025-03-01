package org.minetrio1256.parrot_farm_backend.world.api;

public class Farm {
    private String farmName;  // The name of the farm (for the server)
    private int coins;        // Shared coins for the farm

    // Constructor - Initialize farm data
    public Farm(String farmName, int initialCoins) {
        this.farmName = farmName;
        this.coins = initialCoins;
    }

    // Getter and Setter for farm name
    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    // Getter and Setter for coins
    public int getCoins() {
        return coins;
    }

    public void addCoins(int amount) {
        this.coins += amount;
    }

    public void subtractCoins(int amount) {
        if (coins >= amount) {
            this.coins -= amount;
        } else {
            System.out.println("Not enough coins in the farm.");
        }
    }

    // Method to apply NBT data (if needed, for saving farm state)
    public void applyNBTData() {
        System.out.println("Applying NBT data for farm: " + farmName);
        // Logic for saving farm data (e.g., coins, farm name)
    }

    @Override
    public String toString() {
        return "Farm [name=" + farmName + ", coins=" + coins + "]";
    }
}