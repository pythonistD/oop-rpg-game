package cheboksarov.gameEntities.hero;

import cheboksarov.gameEntities.Characteristics;
import cheboksarov.gameEntities.EnumTypesOperations;
import cheboksarov.gameEntities.items.Inventory;
import cheboksarov.gameEntities.items.Weapon;
import cheboksarov.gameEntities.items.heroItems.FireMagicStaff;
import cheboksarov.gameEntities.items.heroItems.Sword;

import java.util.List;

public enum HeroCharacteristicsTypes implements EnumTypesOperations {

    WARRIOR_BASE(new Sword("Simple Sword", 2, 100, 10), null){
        @Override
        public Characteristics createCharacteristics() {
            return new Characteristics.CharacteristicsBuilder().setCharisma(10).setDexterity(10)
                    .setIntellect(10).setStamina(10).setStrength(20).setWisdom(5).build();

        }
        private final int INVENTORY_SIZE=10;

        @Override
        public Inventory createInventory() {
            Inventory inventory = new Inventory(INVENTORY_SIZE);
            inventory.addItems(List.of(baseWeapon));
            return inventory;
        }
        public int getInventorySize(){
            return INVENTORY_SIZE;
        }

    },
    MAGE_BASE(new FireMagicStaff("Simple Fire Magic Staff",  2,  100,  10), null){
        @Override
        public Characteristics createCharacteristics() {
            return new Characteristics.CharacteristicsBuilder().setCharisma(10).setDexterity(5)
                    .setIntellect(20).setStamina(5).setStrength(5).setWisdom(20).build();

        }
        private final int INVENTORY_SIZE=10;

        @Override
        public Inventory createInventory() {
            Inventory inventory = new Inventory(INVENTORY_SIZE);
            inventory.addItems(List.of(baseWeapon));
            return inventory;
        }

        public int getInventorySize(){
            return INVENTORY_SIZE;
        }
    };

    private final Characteristics characteristics;
    private final Inventory inventory;
    public final Weapon baseWeapon;
    public final Weapon secondaryWeapon;

    HeroCharacteristicsTypes(Weapon baseWeapon, Weapon secondaryWeapon){
        this.baseWeapon = baseWeapon;
        this.secondaryWeapon = secondaryWeapon;
        this.characteristics = createCharacteristics();
        this.inventory = createInventory();
    }

    @Override
    public Characteristics getCharacteristics(){
        return this.characteristics;
    }
    @Override
    public Inventory getInventory(){
        return this.inventory;
    }

}
