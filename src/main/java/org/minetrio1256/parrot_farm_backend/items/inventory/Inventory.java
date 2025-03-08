package org.minetrio1256.parrot_farm_backend.items.inventory;

import org.minetrio1256.parrot_farm_backend.items.Item;
import org.minetrio1256.parrot_farm_backend.items.ItemStack;
import org.minetrio1256.parrot_farm_backend.items.custom.Empty;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private ItemStack items;
    private int maxAmountOfItems;
    private int currentItemAmount;

    public Inventory(int maxAmountOfItems){
        this.maxAmountOfItems = maxAmountOfItems;
        this.items = new ItemStack(new Empty(), 1);
    }

    public int getCurrentItemAmount() {
        return currentItemAmount;
    }

    public int getMaxAmountOfItems() {
        return maxAmountOfItems;
    }

    public void setCurrentItemAmount(int currentItemAmount) {
        this.currentItemAmount = currentItemAmount;
    }

    public void setMaxAmountOfItems(int maxAmountOfItems) {
        this.maxAmountOfItems = maxAmountOfItems;
    }

    public ItemStack getItems() {
        return items;
    }

    public void setItems(ItemStack items) {
        this.items = items;
    }

    public boolean addItem(Item item, int amount){
        ItemStack itemStack = new ItemStack(item, amount);
        if(items == null){
            items = itemStack;
            return true;
        } else if(items.getItem() == item){
            int newAmount = currentItemAmount + amount;
            currentItemAmount = newAmount;
            return true;
        } else if (items.getItem().equals(new Empty())) {
            items = itemStack;
            return true;
        } else {
            return false;
        }
    }
}