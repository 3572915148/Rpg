package RpgGame.character.player;

import RpgGame.equipment.Equipment;
import RpgGame.equipment.Inventory;
import RpgGame.equipment.potions.Potions;
import RpgGame.equipment.EquipmentAttributes;

import java.util.HashMap;
import java.util.InputMismatchException;

import RpgGame.character.Character;
import RpgGame.character.enemy.Enemy;
import RpgGame.interfaces.Fight_I;
import RpgGame.ui.Select;

public class Player extends Character implements Fight_I<Character> {
    // 创建一个Player类，包含玩家的基本属性（如生命值、法力值、攻击力、防御力等）
    public Inventory inventory;

    public Player(String name, Integer hp, Integer blue, Integer attack, Integer defense) {
        super(name, hp, blue, attack, defense);
        this.inventory = new Inventory();
    }

    // 展示玩家数据面板
    public void showPlayerStatus() {
        System.out.println("****************************************");
        System.out.println("Name: " + this.name);
        System.out.println("HP: " + this.hp);
        System.out.println("Blue: " + this.blue);
        System.out.println("Attack: " + this.attack);
        System.out.println("Defense: " + this.defense);
        System.out.println("****************************************");
    }

    // 使用各种药水添加对应的属性
    public void usePotions() {
        Integer counter = 1;
        HashMap<Integer, Potions> choiceMap = new HashMap<Integer, Potions>();

        // 获取可选择的药水，并且添加到键值对中，方便后续选择数字使用它
        for (Equipment equipment : inventory.inventoryBloc.values()) {
            if (equipment instanceof Potions) {
                // java不知道equipment这个装备具体是啥类型
                // 因为value是Potions类型，所以这里需要强制转换
                choiceMap.put(counter, (Potions) equipment);

                // 将选项加1
                counter++;
            }
        }

        if (choiceMap.size() <= 0) {
            System.out.println("背包中没有药水，无法使用！");
        }

        System.out.println("背包中有以下药水:");
        // 显示可以选择的药水菜单
        for (Integer key : choiceMap.keySet()) {
            // 输出键值对, 注意因为重写了toString方法，所以但是这里需要获取名字，使用得使用getName方法
            System.out.println(key + ": " + choiceMap.get(key).getName() + "->" + choiceMap.get(key));
        }

        System.out.println("请输入数字选择药水-> : ");

        // 因为键盘操作是一个io（输入输出）操作，在java中所有的io操作都要使用异常处理，所以这里要用try
        try {
            Integer choice = Select.scanner.nextInt();
            // 判断输入是否合法
            if (choice > 0 && choice <= inventory.inventoryBloc.size()) {
                // 根据输入的数字，匹配对应的药水
                Equipment equipment = choiceMap.get(choice);

                // 获取药水会影响玩家的状态
                EquipmentAttributes status = equipment.getStatus();

                // 用完之后就把这个药水移除装备栏
                inventory.removeWepons(equipment.getName());

                // 将药水效果作用至玩家身上
                this.applyEquipmentAttributes(status, false);

                System.out.println("使用" + equipment.getName() + "成功！");
                // 使用完后这里直接return，就会退出使用药水菜单
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("输入的内容不是有效的数字，请重新输入!");
            Select.scanner.next(); // 清除无效输入

            usePotions();
        }
    }

    // 增加装备
    public void addEquipment(Equipment equipment) {
        // 因为有药水这种特殊装备，所以在这里添加了装备之后不要直接将属性作用到玩家身上
        // 当为药水这种装备的话，就只添加到装备栏里，而不作用属性
        if (equipment instanceof Potions) {
            inventory.addEquipment(equipment);
        } else {
            EquipmentAttributes status = inventory.addEquipment(equipment);
            this.applyEquipmentAttributes(status, false);
        }
    }

    // 删除装备
    public void removeEquipment(String equipmentName) {
        EquipmentAttributes status = inventory.removeWepons(equipmentName);
        this.applyEquipmentAttributes(status, true);
    }

    // 应用装备属性至玩家身上
    public void applyEquipmentAttributes(EquipmentAttributes status, boolean isRemoved) {
        if (isRemoved) {
            // 将装备状态从玩家身上移除
            this.attack -= status.attack;
            this.defense -= status.defense;
            this.hp -= status.hp;
            return;
        }

        // 将装备状态作用至玩家身上
        this.attack += status.attack;
        this.defense += status.defense;
        this.hp += status.hp;
    }

    @Override
    public void attack(Fight_I<Character> hurtCharacter) {
        // TODO 后续可能有攻击暴击逻辑，可以在这里实现
        if (hurtCharacter instanceof Enemy) {
            Enemy enemy = (Enemy) hurtCharacter;
            System.out.println("玩家" + this.name + "攻击了" + enemy.name);
            enemy.getHurt(this.attack);
        } else {
            System.out.println(this.name + "不能攻击" + hurtCharacter);
        }
    }

    @Override
    public void getHurt(Integer damage) {
        // TODO 护甲减伤逻辑
        System.out.println("玩家" + this.name + "受到了" + damage + "点伤害");
        // 确保血量不会小于0
        this.hp = Math.max(0, this.hp - damage);
        if (this.hp == 0) {
            System.out.println("玩家死亡，游戏结束!");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}