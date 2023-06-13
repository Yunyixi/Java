package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bdfymn2 {
    public static void main(String[] args) {
        // 创建 Map 集合存储英文和中文的对应关系
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "你好");
        dictionary.put("world", "世界");
        dictionary.put("java", "Java 编程语言");
        dictionary.put("computer", "计算机");

        // 获取用户输入的英文单词
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入英文单词：");
        String word = sc.nextLine();

        // 根据输入的单词查找对应的中文翻译
        String translation = dictionary.get(word);

        // 输出搜索结果或提示信息
        if (translation != null) {
            System.out.println(word + " 的中文翻译是：" + translation);
        } else {
            System.out.println("很抱歉，未找到 " + word + " 的中文翻译。");
        }
    }
}
