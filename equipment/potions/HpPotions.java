package RpgGame.equipment.potions;

import RpgGame.equipment.EquipmentAttributes;

public class HpPotions extends Potions {
    public Integer Hp;

    public HpPotions(String name, Integer Hp) {
        super(name, Hp);
        this.Hp = Hp;
    }

    public Integer getPotion() {
        return potionsPower;
    }

    public EquipmentAttributes getStatus() {
        return new EquipmentAttributes(this.potionsPower, 0, 0);
    }

}
