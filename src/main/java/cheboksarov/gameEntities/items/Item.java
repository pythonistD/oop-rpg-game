package cheboksarov.gameEntities.items;

public abstract class Item {
    private String name;
    private final int size;
    private final int price;
    public Item(String name, int size, int price){
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }
}
