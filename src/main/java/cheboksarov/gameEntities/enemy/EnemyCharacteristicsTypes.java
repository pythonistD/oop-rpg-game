package cheboksarov.gameEntities.enemy;

import cheboksarov.gameEntities.Characteristics;
import cheboksarov.gameEntities.EnumTypesOperations;
import cheboksarov.gameEntities.items.*;

import java.util.List;

public enum EnemyCharacteristicsTypes implements EnumTypesOperations {
    ZOMBIE_BASE(1, 10, 5){
        @Override
        public Characteristics createCharacteristics() {
            return new Characteristics.CharacteristicsBuilder().setCharisma(-100).setDexterity(5)
                    .setIntellect(-100).setStamina(20).setStrength(10).setWisdom(-100).build();

        }

        private final List<Item> items = List.of(
                new RawFlesh("Zombie raw flesh", 1, 5)
        );


        @Override
        public Inventory createInventory() {
            int MAX_INVENTORY_SIZE = 2;

            return generateInventory(MAX_INVENTORY_SIZE, items);
        }
    },
    ZOMBIE_MEDIUM(20, 50, 20){
        @Override
        public Characteristics createCharacteristics() {
            return new Characteristics.CharacteristicsBuilder().setCharisma(-100).setDexterity(20)
                    .setIntellect(-80).setStamina(30).setStrength(20).setWisdom(-80).build();

        }
        private final List<Item> items = List.of(
                new RawFlesh("Zombie raw flesh", 1, 5),
                new Gold("Gold", 1, 10)
        );

        @Override
        public Inventory createInventory() {
            int MAX_INVENTORY_SIZE = 3;

            return generateInventory(MAX_INVENTORY_SIZE, items);
        }
    },
    ZOMBIE_STRONG(100, 100, 100){
        @Override
        public Characteristics createCharacteristics() {
            return new Characteristics.CharacteristicsBuilder().setCharisma(-100).setDexterity(40)
                    .setIntellect(-10).setStamina(60).setStrength(50).setWisdom(-10).build();

        }

        private final List<Item> items = List.of(
                new RawFlesh("Zombie raw flesh", 1, 5),
                new Gold("Gold", 1, 10)
        );

        @Override
        public Inventory createInventory() {
            int MAX_INVENTORY_SIZE = 5;

            return generateInventory(MAX_INVENTORY_SIZE, items);
        }
    },
    SKELETON_BASE(1, 10, 5){
        @Override
        public Characteristics createCharacteristics() {
            return new Characteristics.CharacteristicsBuilder().setCharisma(-100).setDexterity(1)
                    .setIntellect(-100).setStamina(20).setStrength(10).setWisdom(-100).build();

        }
        private final List<Item> items = List.of(
                new SkeletonBone("Skeleton bone", 1, 5)
        );

        @Override
        public Inventory createInventory() {
            int MAX_INVENTORY_SIZE = 2;

            return generateInventory(MAX_INVENTORY_SIZE, items);
        }
    },
    SKELETON_MEDIUM(10, 50, 20){

        @Override
        public Characteristics createCharacteristics() {
            return new Characteristics.CharacteristicsBuilder().setCharisma(-100).setDexterity(10)
                    .setIntellect(-80).setStamina(30).setStrength(20).setWisdom(-80).build();

        }
        private final List<Item> items = List.of(
                new SkeletonBone("Skeleton bone", 1, 5),
                new Gold("Gold", 1, 10)
        );

        @Override
        public Inventory createInventory() {
            int MAX_INVENTORY_SIZE = 3;

            return generateInventory(MAX_INVENTORY_SIZE, items);
        }
    },
    SKELETON_STRONG(100, 100, 100){
        @Override
        public Characteristics createCharacteristics() {
            return new Characteristics.CharacteristicsBuilder().setCharisma(-100).setDexterity(20)
                    .setIntellect(-10).setStamina(60).setStrength(50).setWisdom(-10).build();

        }
        private final List<Item> items = List.of(
                new SkeletonBone("Skeleton bone", 1, 5),
                new Gold("Gold", 1, 10)
        );

        @Override
        public Inventory createInventory() {
            int MAX_INVENTORY_SIZE = 5;

            return generateInventory(MAX_INVENTORY_SIZE, items);
        }
    },
    GOBLIN_BASE(1, 10, 5){
        @Override
        public Characteristics createCharacteristics() {
            return new Characteristics.CharacteristicsBuilder().setCharisma(-100).setDexterity(10)
                    .setIntellect(5).setStamina(20).setStrength(10).setWisdom(1).build();

        }
        private final List<Item> items = List.of(
                new Gold("Gold", 1, 5)
        );

        @Override
        public Inventory createInventory() {
            int MAX_INVENTORY_SIZE = 2;

            return generateInventory(MAX_INVENTORY_SIZE, items);
        }
    },
    GOBLIN_MEDIUM(10, 50, 20){
        @Override
        public Characteristics createCharacteristics() {
            return new Characteristics.CharacteristicsBuilder().setCharisma(-100).setDexterity(20)
                    .setIntellect(10).setStamina(30).setStrength(20).setWisdom(5).build();

        }
        private final List<Item> items = List.of(
                new Gold("Gold", 1, 5)
        );

        @Override
        public Inventory createInventory() {
            int MAX_INVENTORY_SIZE = 3;

            return generateInventory(MAX_INVENTORY_SIZE, items);
        }
    },
    GOBLIN_STRONG(100, 100, 100){
        @Override
        public Characteristics createCharacteristics() {
            return new Characteristics.CharacteristicsBuilder().setCharisma(-100).setDexterity(40)
                    .setIntellect(25).setStamina(60).setStrength(50).setWisdom(10).build();

        }
        private final List<Item> items = List.of(
                new Gold("Gold", 1, 5)
        );
        public final int level = 100;
        public final int hp  =  100;

        @Override
        public Inventory createInventory() {
            int MAX_INVENTORY_SIZE = 5;

            return generateInventory(MAX_INVENTORY_SIZE, items);
        }

    };

    private final Characteristics characteristics;
    private final Inventory inventory;
    public final int damage;
    public final int hp;
    public final int level;

    EnemyCharacteristicsTypes(int level, int hp, int damage){
        this.level = level;
        this.hp = hp;
        this.damage = damage;
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
