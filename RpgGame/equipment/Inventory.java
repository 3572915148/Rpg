package RpgGame.equipment;

import java.util.HashMap;

// import java.util.HashMap;

public class Inventory {
    // 创建一个Inventory类，用于管理玩家的装备栏。
    // 装备栏可以存储不同类型的装备（如武器、防具、药水等）。
    public HashMap<String, Equipment> inventoryBloc;
    public Integer maxSize;

    public Inventory() {
        this.inventoryBloc = new HashMap<>();
        this.maxSize = 6;
    }

    // 实现添加
    public EquipmentAttributes addEquipment(Equipment equipment) {
        if (this.inventoryBloc.size() < maxSize) {
            this.inventoryBloc.put(equipment.getName(), equipment);
            System.out.println("装备" + equipment.getName() + "添加成功！");
            return equipment.getStatus();
        }
        System.out.println(equipment + "添加失败");
        return new EquipmentAttributes(0, 0, 0);
    }

    // 移除功能。
    public EquipmentAttributes removeWepons(String equipmentName) {
        if (this.inventoryBloc.containsKey(equipmentName)) {
            Equipment equipment = this.inventoryBloc.get(equipmentName);
            EquipmentAttributes status = equipment.getStatus();
            this.inventoryBloc.remove(equipmentName);
            System.out.println("装备" + equipmentName + "删除成功！");
            return status;
        }
        System.out.println(equipmentName + "移除失败");
        return new EquipmentAttributes(0, 0, 0);
    }

}
