package RpgGame;

import RpgGame.equipment.Weapons;
import RpgGame.equipment.potions.AttackPotions;
import RpgGame.equipment.potions.HpPotions;
import RpgGame.manager.CharacterManager;
import RpgGame.ui.Select;

import java.util.Optional;

import RpgGame.character.enemy.Enemy;
import RpgGame.character.player.Player;
import RpgGame.character.Character;
import RpgGame.enums.CharacterType;
import RpgGame.equipment.Defense;

public class RpgGame {
    static Weapons greatSword = new Weapons("大剑", 20);
    static Weapons daggerSword = new Weapons("短剑", 10);
    static Defense clothArmor = new Defense("布甲", 20);
    static Defense armour = new Defense("铁甲", 30);
    // static Potions redWater = new Potions("腐败药水", 35);
    static HpPotions HpPotions = new HpPotions("生命值药水", 20);
    static AttackPotions AttackPotions = new AttackPotions("攻击力药水", 10);

    static CharacterManager characterManager = CharacterManager.getInstance();
    static Enemy slime = new Enemy("史莱姆", 30, 0, 5, 0);
    static Enemy goblin = new Enemy("哥布林", 50, 0, 10, 0);

    public static void start() {
        // 做一些初始化的事情，例如添加游戏世界中的人物等
        characterManager.addCharacter(slime);
        characterManager.addCharacter(goblin);
        // 因为游戏玩家不是固定的，是根据实际游玩的玩家来创建的，所以没把它放到上面用static表示
        Player gamer = new Player("石柒", 100, 70, 30, 20);
        characterManager.addCharacter(gamer);

        System.out.println("游戏开始");
        gamer.showPlayerStatus();

        gamer.addEquipment(HpPotions);
        gamer.addEquipment(AttackPotions);
        // gamer.addEquipment(greatSword);
        // gamer.addEquipment(clothArmor);
        // gamer.removeEquipment("短剑");
        // gamer.removeEquipment("布甲");

        // 使用药水
        gamer.usePotions();

        gamer.showPlayerStatus();

        Optional<Character> hurtCharacterOP = Select.selectCharacter(CharacterType.Enemy);
        if (hurtCharacterOP.isEmpty()) {
            System.out.println("选择对象错误");
        }
        gamer.attack((Enemy) hurtCharacterOP.get());
        slime.attack(gamer);

        gamer.showPlayerStatus();
    }
}
