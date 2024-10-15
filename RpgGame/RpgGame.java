package RpgGame;

import RpgGame.equipment.Weapons;
import RpgGame.equipment.potions.AttackPotions;
import RpgGame.equipment.potions.HpPotions;

import java.util.Scanner;

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
        Player gamer = new Player("石柒", 100, 70, 30, 20);
        Enemy slime = new Enemy("史莱姆", 30, 0, 5, 0);
        Enemy goblin = new Enemy("哥布林", 50, 0, 10, 0);
        System.out.println("游戏开始,请选择一个选项:");
        System.out.println("1. 查看装备栏");
        System.out.println("2. 添加装备");
        System.out.println("3. 移除装备");
        System.out.println("4. 查看玩家状态");
        System.out.println("5. 开始战斗");
        System.out.println("6. 退出游戏");

        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                Integer num = sc.nextInt();
                if (num == 1) {
                    // TODO 添加装备之后个属性更新数据
                    gamer.showPlayerStatus();
                    RpgGame.start();
                }
                if (num == 2) {
                    // 根据玩家输入的数字进行选择添加装备的类型
                    System.out.println("请输入需要装备的装备类型:");
                    System.out.println("1.攻击");
                    System.out.println("2.防御");
                    System.out.println("3.药水");
                    try {
                        Scanner sc1 = new Scanner(System.in);
                        Integer num1 = sc1.nextInt();
                        // 当玩家输入数字1时添加攻击类型的装备
                        if (num1 == 1) {
                            System.out.println("请选择你要添加的装备：");
                            System.out.println("1.大剑");
                            System.out.println("2.短剑");
                            // 玩家进行选择添加
                            try {
                                Scanner Weapon = new Scanner(System.in);
                                Integer num2 = Weapon.nextInt();
                                if (num2 == 1) {
                                    gamer.addEquipment(greatSword);
                                    gamer.showPlayerStatus();
                                    RpgGame.start();
                                }
                                if (num2 == 2) {
                                    gamer.addEquipment(daggerSword);
                                    gamer.showPlayerStatus();
                                    RpgGame.start();
                                }
                            } finally {
                                System.out.println("请输入正确的选项");
                                RpgGame.start();
                            }

                        }
                        // 当玩家输入数字2时添加防御类型的装备
                        if (num1 == 2) {
                            System.out.println("请输入你要添加的防御装备名称:");
                            try {
                                Scanner defen = new Scanner(System.in);
                                String defens = defen.nextLine();
                                if (defens.equals(clothArmor.getName())) {
                                    gamer.addEquipment(clothArmor);
                                    gamer.showPlayerStatus();
                                    RpgGame.start();
                                }
                                if (defens.equals(armour.getName())) {
                                    gamer.addEquipment(armour);
                                    gamer.showPlayerStatus();
                                    RpgGame.start();
                                }

                            } finally {
                                System.out.println("请输入正确的名称");
                                RpgGame.start();
                            }

                        }
                        // 当玩家输入数字3时添加药水类型的装备
                        if (num1 == 3) {
                            System.out.println("请输入你要添加的药水装备名称:");
                            try {
                                Scanner Potion = new Scanner(System.in);
                                String Potions = Potion.nextLine();
                                if (Potions.equals(HpPotions.getName())) {
                                    gamer.addEquipment(HpPotions);
                                    gamer.showPlayerStatus();
                                    RpgGame.start();
                                }
                                if (Potions.equals(AttackPotions.getName())) {
                                    gamer.addEquipment(AttackPotions);
                                    gamer.showPlayerStatus();
                                    RpgGame.start();
                                }
                            } finally {
                                System.out.println("请输入正确的名称");
                                RpgGame.start();
                            }
                        }
                    } finally {
                        System.out.println("请输入正确的选项！");
                        RpgGame.start();
                    }

                }
                if (num == 3) {

                }
                if (num == 4) {

                }
                if (num == 5) {
                    // ; > 5
                    // ; 请选择一个敌人：
                    // ; 1. 史莱姆（生命值：30，攻击力：5）
                    // ; 2. 哥布林（生命值：50，攻击力：10）

                    // > 1
                    // ; 你选择了史莱姆！

                    // ; 请选择一个动作：
                    // ; 1. 攻击
                    // ; 2. 使用装备栏中的物品

                    // ; > 1
                    // ; 你攻击了史莱姆，造成了10点伤害！
                    // ; 史莱姆攻击了你，造成了5点伤害！

                    // ; 请选择一个动作：
                    // ; 1. 攻击
                    // ; 2. 使用装备栏中的物品

                    // ; > 2
                    // ; 请选择一个物品：
                    // ; 1. 长剑（类型：武器，攻击力：10）
                    // ; 2. 药水（类型：药水，恢复量：20）

                    // ; > 2
                    // ; 你使用了药水，恢复了20点生命值！

                    // ; 请选择一个动作：
                    // ; 1. 攻击
                    // ; 2. 使用装备栏中的物品

                    // ; > 1
                    // ; 你攻击了史莱姆，造成了10点伤害！
                    // ; 史莱姆被击败了！
                }
                if (num == 6) {

                    return;
                }
                if (num != 1 && num != 2 && num != 3 && num != 4 && num != 5 && num != 6) {
                    System.out.println("请输入正确的选项");
                    RpgGame.start();
                }
            } catch (Exception e) {
                System.out.println("请输入正确的选项");
                RpgGame.start();
            }
        }

    }
}
