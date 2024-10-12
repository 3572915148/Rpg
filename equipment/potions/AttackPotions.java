package RpgGame.equipment.potions;

import RpgGame.equipment.EquipmentAttributes;

public class AttackPotions extends Potions {
    public Integer attackPower;

    public AttackPotions(String name, Integer attackPower) {
        super(name, attackPower);
        this.attackPower = attackPower;
    }

    public Integer getAttack() {
        return this.attackPower;
    }

    public EquipmentAttributes getStatus() {
        return new EquipmentAttributes(0, this.attackPower, 0);
    }
}
