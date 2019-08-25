package cn.com.clearlight.setframe.map.demo;

import java.util.HashMap;
import java.util.Map;

public class MapErgodicDemo {
    public static void main(String[] args) {
        // 使用foreach遍历map集合,需要先将map转成单列的set
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "zhangsan");
        map.put(2, "lisi");
        map.put(4, "wangwu");
        map.put(3, "liuyi");

        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }

        for (Map.Entry<Integer, String> me : map.entrySet()) {
            Integer key = me.getKey();
            String value = me.getValue();

            System.out.println(key + " :: " + value);
        }
    }
}
