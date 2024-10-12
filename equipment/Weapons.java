package RpgGame.equipment;

public class Weapons extends Equipment {
    private Integer attackPower;

    public Weapons(String name, Integer attackPower) {
        super(name);
        this.attackPower = attackPower;
    }

    public Integer getAttack() {
        return this.attackPower;
    }

    public EquipmentAttributes getStatus() {
        return new EquipmentAttributes(0, this.attackPower, 0);
    }
}
