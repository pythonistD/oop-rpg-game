package cheboksarov.gameEntities;

public abstract class AliveBeing {
    private int health;
    private int level;

    public AliveBeing(int health, int level){
        this.health = validateHealth(health);
        this.level = level;
    }

    private int validateHealth(int health){
        if(health <= 0 || health > 1000){
            throw new IllegalArgumentException("Health must be between 1 and 1000");
        }
        return health;
    }
    public void heal(int hp){
        health += hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public abstract void attack(AliveBeing target);

    public void takeDamage(int damage){
        health -= validateDamage(damage);
    }

    private int validateDamage(int damage){
        if(damage < 0 || damage > 1000){
            throw new IllegalArgumentException("Damage must be between 1 and 1000");
        }
        return damage;
    }

    public int getHealth(){
        return health;
    }
}
