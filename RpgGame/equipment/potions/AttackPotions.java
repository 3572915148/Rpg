package RpgGame.equipment.potions;

import RpgGame.equipment.EquipmentAttributes;

public class AttackPotions extends Potions {
    public AttackPotions(String name, Integer attack) {
        super(name, attack);
    }

    @Override
    public EquipmentAttributes getStatus() {
        return new EquipmentAttributes(0, this.potionsPower, 0);
    }
}
