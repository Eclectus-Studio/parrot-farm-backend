package org.minetrio1256.parrot_farm_backend.items;

public class ItemStack {
    private int amount;
    private Item item;

    public ItemStack(Item item, int amount){
        this.item = item;
        this.amount = amount;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount(){
        return amount;
    }

    public void addOneToItemStack(){
        amount++;
    }

    public void setAmount(int i){
        amount = i;
    }

    public void addToAmount(int i){
        int total = amount + i;
        amount = total;
    }
}
