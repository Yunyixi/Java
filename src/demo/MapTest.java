package demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        //map 无序，不重复
        HashMap<String, String> map = new HashMap();
        map.put("0771", "南宁");
        map.put("0772", "柳州");
        map.put("0773", "桂林");
        Set keySet = map.keySet();
        System.out.println(keySet);
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            Object key = it.next();//每次获取一个
            Object value = map.get(key);//用钥匙去获取内容
            System.out.println("---" + value);

        }
        System.out.println("-----------------");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " 增强for--" + entry.getValue());
        }
    }
}
