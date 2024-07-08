package cheboksarov.gameEntities.items;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final int capacity;
    private final ArrayList<Item> items;
    public Inventory(int capacity){
        this.capacity = capacity;
        this.items = new ArrayList<Item>();
    }

    public Inventory(int capacity, List<Item> items){
        this.capacity = capacity;
        this.items = new ArrayList<Item>(items);
    }

    public void addItems(List<Item> items){
        this.items.addAll(items);
    }

    public void removeItems(List<Item> items){
        this.items.removeAll(items);
    }

    public int getCapacity() {
        return capacity;
    }
    public List<Item> getItems() {
        return items;
    }
}
