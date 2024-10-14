package RpgGame;

import RpgGame.equipment.Weapons;
import RpgGame.equipment.potions.AttackPotions;
import RpgGame.equipment.potions.HpPotions;
import RpgGame.character.enemy.Enemy;
import RpgGame.character.player.Player;
import RpgGame.equipment.Defense;

public class RpgGame {
    static Weapons greatSword = new Weapons("大剑", 20);
    static Weapons daggerSword = new Weapons("短剑", 10);
    static Defense clothArmor = new Defense("布甲", 20);
    static Defense armour = new Defense("铁甲", 30);
    // static Potions redWater = new Potions("腐败药水", 35);
    static HpPotions HpPotions = new HpPotions("生命值药水", 20);
    static AttackPotions AttackPotions = new AttackPotions("攻击力药水", 10);

    public static void start() {
        System.out.println("游戏开始");
        Player gamer = new Player("石柒", 100, 70, 30, 20);
        Enemy slime = new Enemy("史莱姆", 30, 0, 5, 0);
        Enemy goblin = new Enemy("哥布林", 50, 0, 10, 0);
        gamer.showPlayerStatus();

        // 添加药水
        gamer.addEquipment(AttackPotions);
        gamer.addEquipment(HpPotions);

        // 添加装备
        // gamer.addEquipment(greatSword);
        // gamer.addEquipment(clothArmor);

        // 使用药水
        gamer.usePotions();
        // gamer.removeEquipment("短剑");
        // gamer.removeEquipment("布甲");

        // gamer.attack(slime);
        // slime.attack(gamer);

        // gamer.showPlayerStatus();

        // // gamer.attack(slime);
        // gamer.attack(goblin);
        // System.out.println("*************");
        // slime.attack(goblin);

    }
}
