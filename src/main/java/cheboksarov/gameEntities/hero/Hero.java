package cheboksarov.gameEntities.hero;

import cheboksarov.gameEntities.AliveBeing;
import cheboksarov.gameEntities.Characteristics;
import cheboksarov.gameEntities.items.Inventory;
import cheboksarov.gameEntities.items.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Hero extends AliveBeing {
    private final String name;
    private ArrayList<Hero> team;
    private final Inventory inventory;
    private final Characteristics characteristics;
    private int selectedWeapon;
    private Weapon baseWeapon;
    private Weapon secondaryWeapon;
    private final int heroId;
    private static int currentHeroMaxId;
    static {
        currentHeroMaxId = 0;
    }

    {
        heroId = ++currentHeroMaxId;
    }

    public Hero(String name, int health, int level, Characteristics characteristics){
        super(health, level);
        this.name = name;
        this.inventory = new Inventory(100);
        this.characteristics = characteristics;
    }
    public Hero(String name, int health, int level, Characteristics characteristics, Inventory inventory){
        super(health, level);
        this.name = name;
        this.inventory = inventory;
        this.characteristics = characteristics;
    }
    public Hero(String name, int health, int level, Characteristics characteristics, Inventory inventory, Weapon baseWeapon){
        super(health, level);
        this.name = name;
        this.inventory = inventory;
        this.characteristics = characteristics;
        this.baseWeapon  = baseWeapon;
    }

    @Override
    public void attack(AliveBeing target) {
        if(selectedWeapon == 0){
            target.takeDamage(baseWeapon.getDamage());
        }else if(selectedWeapon ==  1){
            target.takeDamage(secondaryWeapon.getDamage());
        }else{
            throw new RuntimeException("No weapon selected");
        }
    }

    public int getSelectedWeapon() {
        return selectedWeapon;
    }

    public void setSelectedWeapon(int selectedWeapon) {
        if(selectedWeapon < 0 || selectedWeapon > 1) {
            throw new RuntimeException("No weapon selected");
        }else{
            this.selectedWeapon = selectedWeapon;
        }
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public String getName(){
        return this.name;
    }

    public List<Hero> getTeam(){
        return this.team;
    }
    public void addToTeam(Hero hero){
        this.team.add(hero);
    }

    public void removeFromTeam(Hero hero){
        this.team.remove(hero);
    }
    public Inventory getInventory(){
        return this.inventory;
    }

    public Weapon getBaseWeapon() {
        return baseWeapon;
    }

    public void setBaseWeapon(Weapon baseWeapon) {
        this.baseWeapon = baseWeapon;
    }

    public Weapon getSecondaryWeapon() {
        return secondaryWeapon;
    }

    public void setSecondaryWeapon(Weapon secondaryWeapon) {
        this.secondaryWeapon = secondaryWeapon;
    }
    public int getHeroId(){
        return this.heroId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero hero)) return false;
        return heroId == hero.heroId && Objects.equals(name, hero.name) && Objects.equals(characteristics, hero.characteristics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, characteristics, heroId);
    }
}
