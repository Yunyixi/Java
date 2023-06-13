package guess;

import java.util.Scanner;

public class Judge {
    public void startGame(Player player, Computer computer) { // 游戏开始
        System.out.println("游戏开始！");
        int playerFist = player.showFist(); // 玩家出拳
        int computerFist = computer.showFist(); // 电脑出拳

        if ((playerFist == 1 && computerFist == 3) || (playerFist == 2 && computerFist == 1) || (playerFist == 3 && computerFist == 2)) {
            System.out.println(player.getName() + "赢了！");
        } else if (playerFist == computerFist) {
            System.out.println("平局！");
        } else {
            System.out.println(computer.getName() + "赢了！");
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("是否继续游戏？（y/n）:");
        String input = sc.nextLine();

        if (input.equals("y")) { // 继续游戏
            startGame(player, computer);
        } else { // 结束游戏
            System.out.println("游戏结束！");
        }
    }
}
