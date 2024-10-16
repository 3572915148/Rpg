package RpgGame.manager;

import java.util.HashMap;
import RpgGame.character.Character;
import RpgGame.enums.CharacterType;
import RpgGame.character.enemy.Enemy;
import RpgGame.character.player.Player;

public class CharacterManager {
    // 使用 volatile 确保多线程环境下的可见性
    private static volatile CharacterManager instance;
    private HashMap<String, Character> characterPool = new HashMap<>();

    // 私有构造函数防止外部实例化
    private CharacterManager() {
    }

    // 双重检查锁定以确保线程安全
    public static CharacterManager getInstance() {
        if (instance == null) {
            synchronized (CharacterManager.class) {
                if (instance == null) {
                    instance = new CharacterManager();
                }
            }
        }
        return instance;
    }

    public void addCharacter(Character character) {
        characterPool.put(character.name, character);
    }

    public void removeCharacter(String characterName) {
        characterPool.remove(characterName);
    }

    public HashMap<String, Character> getAllCharacters(CharacterType characterType) {
        switch (characterType) {
            case CharacterType.All:
                return new HashMap<>(this.characterPool);

            case CharacterType.Player:
                HashMap<String, Character> playerPool = new HashMap<>();
                for (Character character : characterPool.values()) {
                    if (character instanceof Player) {
                        playerPool.put(character.name, character);
                    }
                }
                return playerPool;

            case CharacterType.Enemy:
                HashMap<String, Character> enemyPool = new HashMap<>();
                for (Character character : characterPool.values()) {
                    if (character instanceof Enemy) {
                        enemyPool.put(character.name, character);
                    }
                }
                return enemyPool;

            default:
                System.out.println("不支持获取该类型的角色池");
                break;
        }
        return new HashMap<>(this.characterPool); // 返回拷贝以防止外部修改
    }

    public Character getCharacter(String characterName) {
        return this.characterPool.get(characterName);
    }
}
