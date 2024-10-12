package RpgGame.character;

public abstract class Character {
    public String name;
    public int hp;
    public int blue;
    public int attack;
    public int defense;

    public Character(String name, int hp, int blue, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.blue = blue;
        this.attack = attack;
        this.defense = defense;
    }

}
