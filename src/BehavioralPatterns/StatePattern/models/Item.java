package BehavioralPatterns.StatePattern.models;

public class Item {

    ItemType itemType;

    String name;

    int price;

    int id;

    public Item(ItemType itemType, String name, int price, int id){
        this.itemType = itemType;
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public Item() {

    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
