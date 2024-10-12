package RpgGame.character.player;

import RpgGame.equipment.Equipment;
import RpgGame.equipment.Inventory;
import RpgGame.equipment.EquipmentAttributes;
import RpgGame.equipment.potions.Potions;
import RpgGame.character.Character;
import RpgGame.character.enemy.Enemy;
import RpgGame.interfaces.Fight_I;

public class Player extends Character implements Fight_I<Character> {
    // 创建一个Player类，包含玩家的基本属性（如生命值、法力值、攻击力、防御力等）
    public Inventory inventory;

    public Player(String name, int hp, int blue, int attack, int defense) {
        super(name, hp, blue, attack, defense);
        this.inventory = new Inventory();
    }

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
    public void addPotions(Equipment potions) {
        if (potions instanceof Potions) {
            EquipmentAttributes potions1 = inventory.addEquipment(potions);
            this.applyequipmentAttributes(potions1, false);
        } else {
            System.out.println("使用失败");
        }
    }

    // 增加装备属性
    public void addEquipment(Equipment equipment) {
        EquipmentAttributes status = inventory.addEquipment(equipment);
        this.applyequipmentAttributes(status, false);
    }

    // 删除装备属性
    public void removeEquipment(String equipmentName) {
        EquipmentAttributes status = inventory.removeWepons(equipmentName);
        this.applyequipmentAttributes(status, true);
    }

    public void applyequipmentAttributes(EquipmentAttributes status, boolean isRemoved) {
        if (isRemoved) {
            // 将装备状态从玩家身上移除
            this.attack -= status.attackPower;
            this.defense -= status.defensePower;
            this.hp -= status.potionsPower;
            return;
        }

        // 将装备状态作用至玩家身上
        this.attack += status.attackPower;
        this.defense += status.defensePower;
        this.hp += status.potionsPower;
    }

    @Override
    public void attack(Fight_I<Character> hurtCharacter) {
        // TODO 后续可能有攻击暴击逻辑，可以在这里实现
        if (hurtCharacter instanceof Enemy) {
            Enemy enemy = (Enemy) hurtCharacter;
            System.out.println("敌人" + this.name + "攻击了" + enemy.name);
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