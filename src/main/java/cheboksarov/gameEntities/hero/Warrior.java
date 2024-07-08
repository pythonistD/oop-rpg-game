package cheboksarov.gameEntities.hero;

import cheboksarov.gameEntities.AliveBeing;
import cheboksarov.gameEntities.Characteristics;
import cheboksarov.gameEntities.items.Inventory;
import cheboksarov.gameEntities.items.Weapon;

public class Warrior extends Hero{

    public Warrior(String name, int health, int level, Characteristics characteristics, Inventory inventory) {
        super(name, health, level, characteristics, inventory);
    }
    public Warrior(String name, int health, int level, Characteristics characteristics, Inventory inventory, Weapon weapon) {
        super(name, health, level, characteristics, inventory, weapon);
    }
}
