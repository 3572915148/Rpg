package RpgGame.ui;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import RpgGame.character.Character;
import RpgGame.enums.CharacterType;
import RpgGame.manager.CharacterManager;

public class Select {
    public static final Scanner scanner = new Scanner(System.in);

    public static Optional<Character> selectCharacter(CharacterType characterType) {
        Integer counter = 1;
        CharacterManager characterManager = CharacterManager.getInstance();
        HashMap<String, Character> characterPool = characterManager.getAllCharacters(characterType);
        HashMap<Integer, Character> choiceMap = new HashMap<Integer, Character>();

        if (characterPool.size() == 0) {
            System.out.println("游戏中没有角色，请先添加角色后重试!");
            return Optional.empty();
        }

        // 获取可选择的角色对象，并且添加到键值对中，方便后续选择数字使用它
        for (Character character : characterPool.values()) {
            choiceMap.put(counter, character);
            counter++;
        }

        System.out.println("有以下角色:");
        // 显示可以选择的角色菜单
        for (Integer key : choiceMap.keySet()) {
            System.out.println(key + ": " + choiceMap.get(key).name);
        }

        System.out.println("请输入数字选择目标-> : ");
        // 因为键盘操作是一个io（输入输出）操作，在java中所有的io操作都要使用异常处理，所以这里要用try
        try {
            Integer choice = scanner.nextInt();
            // 判断输入是否合法
            if (choice > 0 && choice <= characterPool.size()) {
                // 根据输入的数字，匹配对应的角色
                Character character = choiceMap.get(choice);
                return Optional.of(character);
            }
            System.out.println("输入的数字不合法，请重新输入!");
            return Optional.empty();
        } catch (InputMismatchException e) {
            System.out.println("输入的内容不是有效的数字，请重新输入!");
            scanner.next(); // 清除无效输入
            return Optional.empty();
        }
    }
}
