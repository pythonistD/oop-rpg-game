package cheboksarov.gameEntities.items;

import cheboksarov.gameEntities.hero.Hero;

public interface UsableItem {
    void use(Hero hero);
    int durationOfPotion();
}
