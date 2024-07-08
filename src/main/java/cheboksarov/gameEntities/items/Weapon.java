package cheboksarov.gameEntities.items;

public class Weapon extends Item{
    private final int damage;

    public Weapon(String name, int size, int price, int damage) {
        super(name, size, price);
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
}
