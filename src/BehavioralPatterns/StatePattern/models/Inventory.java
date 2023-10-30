package BehavioralPatterns.StatePattern.models;

import java.util.List;

public class Inventory {

    private ItemShelf[] inventory;

    Inventory(int itemCount){
        this.inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf item = new ItemShelf();
            item.setShelfId(startCode);
            inventory[i]= item;
            startCode++;
        }
    }

    public void addItem(Item item, int code) throws Exception {
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getShelfId() == code) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("already item is present, you can not add item here");
                }
            }

        }
    }

    public Item get(int code) throws Exception {
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getShelfId() == code && !itemShelf.isSoldOut()) {
                return itemShelf.getItem();
            }
        }
        throw new Exception("Item sold out or item shelf code invalid");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getShelfId() == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }

}
