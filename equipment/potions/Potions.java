package RpgGame.equipment.potions;

import RpgGame.equipment.Equipment;
import RpgGame.equipment.EquipmentAttributes;

public class Potions extends Equipment {
    public Integer potionsPower;

    public Potions(String name, Integer potionsPower) {
        super(name);
        this.potionsPower = potionsPower;
    }

    public Integer getPotion() {
        return potionsPower;
    }

    public EquipmentAttributes getStatus() {
        return new EquipmentAttributes(this.potionsPower, 0, 0);
    }
}
