package guess;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("玩家"); // 创建玩家对象
        Computer computer = new Computer("电脑"); // 创建电脑对象
        Judge judge = new Judge(); // 创建裁判对象

        judge.startGame(player, computer); // 开始游戏
    }
}

