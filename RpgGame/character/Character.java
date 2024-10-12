package RpgGame.character;

public abstract class Character {
    public String name;
    public Integer hp;
    public Integer blue;
    public Integer attack;
    public Integer defense;

    public Character(String name, Integer hp, Integer blue, Integer attack, Integer defense) {
        this.name = name;
        this.hp = hp;
        this.blue = blue;
        this.attack = attack;
        this.defense = defense;
    }

}
