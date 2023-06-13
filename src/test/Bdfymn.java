package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bdfymn {//简单翻译

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap();
        map.put("xiaomi", "小米");
        map.put("huawei", "华为");
        map.put("pingguo", "苹果");
        map.put("sanxing", "三星");
        //从键盘输入，输出结果
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要翻译的内容");
        String sc1 = sc.next();//获取键盘输入的内容
        boolean flag = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //getKey()--得到英文    getValue()得到中文
            if (entry.getKey().equals(sc1)) {
                System.out.println(sc1 + " 的翻译是：" + entry.getValue());
                flag = true;
            } else if (entry.getValue().equals(sc1)) {
                System.out.println(sc1 + "中文翻译是：" + entry.getKey());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("暂未录入");
        }
    }
}
