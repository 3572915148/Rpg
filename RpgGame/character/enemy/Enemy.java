package RpgGame.character.enemy;

import RpgGame.character.Character;
import RpgGame.character.player.Player;
import RpgGame.interfaces.Fight_I;

public class Enemy extends Character implements Fight_I<Character> {
    // 创建一个Enemy类，包含敌人的基本属性（如生命值、攻击力、防御力等）。

    public Enemy(String name, Integer hp, Integer blue, Integer attack, Integer defense) {
        super(name, hp, blue, attack, defense);
    }

    @Override
    public void attack(Fight_I<Character> hurtCharacter) {
        if (hurtCharacter instanceof Player) {
            Player player = (Player) hurtCharacter;
            System.out.println("敌人" + this.name + "攻击了" + player.name);
            player.getHurt(this.attack);
        } else {
            System.out.println(this.name + "不能攻击" + hurtCharacter);
        }
    }

    @Override
    public void getHurt(Integer damage) {
        // 确保血量不会小于0

        System.out.println("敌人" + this.name + "受到了" + damage + "点伤害");

        this.hp = Math.max(0, this.hp - damage);
        if (this.hp <= 0) {
            System.out.println("敌人" + this.name + "已死亡");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
