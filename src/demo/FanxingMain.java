package demo;

import java.util.ArrayList;

public class FanxingMain {
    public static void main(String[] args) {
        Fanxing<String> fanxing = new Fanxing();
        fanxing.setT("字符串");
        System.out.println(fanxing.getT());

        Fanxing<Integer> fanxing1 = new Fanxing();
        fanxing1.setT(6);
        System.out.println(fanxing1.getT());

        //这个集合只能放String类型
        ArrayList arrayList = new ArrayList();
    }
}
