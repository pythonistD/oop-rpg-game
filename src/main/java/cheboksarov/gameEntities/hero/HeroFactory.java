package cheboksarov.gameEntities.hero;

public class HeroFactory {

    public static Hero createHero(String name, HeroCharacteristicsTypes type) {
        String prefix = type.name().split("_")[0];
        switch (prefix){
            case "WARRIOR" -> {
                return new Warrior(name, 100, 1, type.getCharacteristics(), type.getInventory(), type.baseWeapon);
            }
            case "MAGE" -> {
                return new Mage(name, 100, 1, type.getCharacteristics(), type.getInventory(), type.baseWeapon);
            }
            default -> {
                throw new IllegalArgumentException("Invalid hero type");
            }
        }

    }

}
