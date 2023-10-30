package BehavioralPatterns.StatePattern.models;

public class ItemShelf {

    private int shelfId;

    private Item item;

    private boolean soldOut;

    ItemShelf(int shelfId, Item item, boolean soldOut){
        this.shelfId = shelfId;
        this.item = item;
        this.soldOut = soldOut;
    }

    public ItemShelf() {
        this.shelfId = 0;
        this.item = null;
        this.soldOut = true;
    }

    public int getShelfId() {
        return shelfId;
    }

    public void setShelfId(int shelfId) {
        this.shelfId = shelfId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }
}
