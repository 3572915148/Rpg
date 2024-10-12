package RpgGame.equipment.potions;

import RpgGame.equipment.Equipment;
import RpgGame.equipment.EquipmentAttributes;

public abstract class Potions extends Equipment {
    public Integer potionsPower;

    public Potions(String name, Integer potionsPower) {
        super(name);
        this.potionsPower = potionsPower;
    }

    public Integer getPotion() {
        return potionsPower;
    }

    // 抽象出来，交给子类去实现，具体的药水效果是啥
    public abstract EquipmentAttributes getStatus();

    @Override
    public String toString() {
        // 因为toString需要一个String类型的字符串，所以下面需要把potionsPower整数转换成字符串
        return String.valueOf(this.potionsPower);
    }
}
