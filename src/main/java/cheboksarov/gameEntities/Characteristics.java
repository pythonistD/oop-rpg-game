package cheboksarov.gameEntities;

public class Characteristics {
    private int strength;
    private int dexterity;
    private int intellect;
    private int stamina;
    private int wisdom;
    private int charisma;
    public Characteristics(int strength, int dexterity, int intellect, int stamina, int wisdom, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.stamina = stamina;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public Characteristics(CharacteristicsBuilder characteristicsBuilder){
        this.strength  = characteristicsBuilder.strength;
        this.dexterity  = characteristicsBuilder.dexterity;
        this.intellect   = characteristicsBuilder.intellect;
        this.stamina  = characteristicsBuilder.stamina;
        this.wisdom  = characteristicsBuilder.wisdom;
        this.charisma  = characteristicsBuilder.charisma;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
    public static class CharacteristicsBuilder {
        private int strength;
        private int dexterity;
        private int intellect;
        private int stamina;
        private int wisdom;
        private int charisma;

        public CharacteristicsBuilder()  {

        }

        public CharacteristicsBuilder setStrength(int strength){
            this.strength = strength;
            return this;
        }
        public CharacteristicsBuilder setDexterity(int dexterity){
            this.dexterity = dexterity;
            return this;
        }
        public CharacteristicsBuilder setIntellect(int intellect){
            this.intellect = intellect;
            return this;
        }
        public CharacteristicsBuilder setStamina(int stamina){
            this.stamina = stamina;
            return this;
        }
        public CharacteristicsBuilder setWisdom(int wisdom){
            this.wisdom  = wisdom;
            return this;
        }
        public CharacteristicsBuilder setCharisma(int charisma){
            this.charisma = charisma;
            return this;
        }

        public Characteristics build(){
            return new Characteristics(this);
        }

    }
}
