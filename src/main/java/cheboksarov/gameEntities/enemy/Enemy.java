package cheboksarov.gameEntities.enemy;

import cheboksarov.gameEntities.AliveBeing;
import cheboksarov.gameEntities.Characteristics;
import cheboksarov.gameEntities.items.CanBeDroped;
import cheboksarov.gameEntities.items.Inventory;

import java.util.List;

public abstract class Enemy extends AliveBeing {
    private final Inventory inventory;
    private final Characteristics characteristics;
    private final EnemyCharacteristicsTypes type;
    private final int damage;

    public Enemy(EnemyCharacteristicsTypes type) {
        super(type.level, type.hp);
        this.type = type;
        this.characteristics = type.getCharacteristics();
        this.inventory = type.getInventory();
        this.damage = type.damage;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public Characteristics getCharacteristics()  {
        return characteristics;
    }
    public EnemyCharacteristicsTypes getType()  {
        return type;
    }

    @Override
    public void attack(AliveBeing target) {
        target.takeDamage(damage);
    }

    public int getDamage()   {
        return damage;
    }
}
