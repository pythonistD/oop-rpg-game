package cheboksarov.gameEntities;

import cheboksarov.gameEntities.items.Inventory;
import cheboksarov.gameEntities.items.Item;

import java.util.List;
import java.util.Random;

public interface EnumTypesOperations {
    Random random = new Random();

     Characteristics createCharacteristics();
     Inventory createInventory();
     Characteristics getCharacteristics();
     Inventory getInventory();

     default int getRandomFromRange(int upBorder){
         return random.nextInt(upBorder);
     }

    default Inventory generateInventory(int maxInventorySize, List<Item> itemsToDrop) {
        int numberOfItemsCouldBeDropped = itemsToDrop.size();
        int currentInventorySize = getRandomFromRange(maxInventorySize);
        Inventory inventory  = new Inventory(currentInventorySize);

        for(int i=0; i<currentInventorySize; i++){
            int IndexOfItemToAdd = getRandomFromRange(numberOfItemsCouldBeDropped);
            inventory.addItems(List.of(itemsToDrop.get(IndexOfItemToAdd)));
        }
        return inventory;
    }
}
