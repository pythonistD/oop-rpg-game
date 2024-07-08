package cheboksarov.gameEntities.TextGameView;

import cheboksarov.gameEntities.hero.Hero;

import java.util.HashSet;
import java.util.Optional;

public class ViewModel {
    private Hero currentHero;
    private HashSet<Hero> heroes;
    private String name;
    private int health;
    private int hp;

    public ViewModel(){
        heroes = new HashSet<>();
    }

    public Hero getCurrentHero() {
        return currentHero;
    }

    public void setCurrentHero(Hero currentHero) {
        this.currentHero = currentHero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public HashSet<Hero> getHeroes() {
        return heroes;
    }
    public Hero findGeroById(int id){
        return heroes.stream().filter(hero1 -> hero1.getHeroId() == id).findFirst().orElseThrow();
    }

    public void addNewHero(Hero hero) {
        Optional<Hero> heroTheSame = heroes.stream().filter(hero1 -> hero1.equals(hero)).findFirst();
        if(heroTheSame.isPresent()){
            throw new RuntimeException("Hero already exists");
        }else{
            heroes.add(hero);
        }
    }
}
