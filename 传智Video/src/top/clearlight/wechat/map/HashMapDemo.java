package top.clearlight.wechat.map;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        Map m1 = new HashMap<>();
        // 此类不保证映射的顺序,特别是它不保证该顺序恒久不变
        m1.put("姓名", "Jack");
        m1.put("age", 16);
        // m1.put("性别", '男');
        m1.put("电话", "13313313090");
        m1.put(null, "is null");
        m1.put("地址", null);
        System.out.println("第一种输出方法 : " + m1);
        System.out.println(m1.containsKey("张三丰") + " " + m1.containsValue(16));

        // 第二种方法 取出键
        Set keySet = m1.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next + "," + m1.get(next));
        }

        // 取出值
        Collection values = m1.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        // 第三种方法同时取出键和值
        // m1.clear; //清空;
        // m1.remove("性别");
        // 有无此键
        System.out.println(m1.containsKey("姓名"));
        System.out.println(m1.containsValue("Jack"));
        Set entrySet = m1.entrySet();
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        System.out.println(m1.size());
    }
}
