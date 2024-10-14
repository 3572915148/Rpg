package RpgGame.equipment.potions;

import RpgGame.equipment.EquipmentAttributes;

public class HpPotions extends Potions {
    public HpPotions(String name, Integer hp) {
        super(name, hp);
    }

    @Override
    public EquipmentAttributes getStatus() {
        return new EquipmentAttributes(this.potionsPower, 0, 0);
    }

}
