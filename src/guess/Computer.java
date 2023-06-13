package guess;

import java.util.Random;

public class Computer {
    private String name; // 电脑名称

    public Computer(String name) { // 构造方法
        this.name = name;
    }

    public String getName() { // 获取电脑名称
        return name;
    }

    public int showFist() { // 电脑随机出拳
        Random rand = new Random();
        int input = rand.nextInt(3) + 1;
        System.out.println(name + "出拳：" + input);
        return input;
    }
}

