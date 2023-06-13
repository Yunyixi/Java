package guess;

import java.util.Scanner;

public class Player {
    private String name; // 玩家姓名

    public Player(String name) { // 构造方法
        this.name = name;
    }

    public String getName() { // 获取玩家姓名
        return name;
    }

    public int showFist() { // 玩家出拳
        Scanner sc = new Scanner(System.in);
        System.out.print(name + "请出拳（1-剪刀；2-石头；3-布）：");
        int input = sc.nextInt();
        if (input < 1 || input > 3) { // 判断输入是否合法
            System.out.println("输入有误，请重新输入！");
            return showFist(); // 输入错误，重新出拳
        } else {
            return input;
        }
    }
}
