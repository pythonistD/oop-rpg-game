package cheboksarov.gameEntities.items;

import cheboksarov.gameEntities.hero.Hero;

public class Potion extends Item implements UsableItem{
    private final int buffAmount;
    private final int duration;
    private final PotionTypes type;
    public Potion(String name, int size, int price, int buffAmount, int duration, PotionTypes type) {
        super(name, size, price);
        this.buffAmount = buffAmount;
        this.duration = duration;
        this.type  = type;
    }

    @Override
    public void use(Hero hero) {
        switch (type){
            case STRENGTH -> {
                int currentStrength = hero.getCharacteristics().getStrength();
                hero.getCharacteristics().setStrength(currentStrength + buffAmount);
            }
            case HEALTH ->{
                int currentHealth = hero.getHealth();
                hero.heal(currentHealth  + buffAmount);
            }
            case WISDOM -> {
                int currentWisdom = hero.getCharacteristics().getWisdom();
                hero.getCharacteristics().setWisdom(currentWisdom + buffAmount);
            }
        }


    }

    @Override
    public int durationOfPotion() {
        return duration;
    }

}
