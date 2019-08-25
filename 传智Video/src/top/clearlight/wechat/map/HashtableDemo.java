package top.clearlight.wechat.map;

import java.util.*;

/**
 * Hashtable线程是安全的,同步的
 * 元素是无序排列的
 */
public class HashtableDemo {
    public static void main(String[] args) {
        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put("张三", 18);
        ht.put("李四", 30);
        ht.put("王五", 28);
        // 键和值都不允许为null
        // ht.put(null, null);

        // 第一种遍历方式 : 直接打印对象
        System.out.println(ht);

        System.out.println("----------");


        // 第二种遍历方式 : 返回key集
        Set<String> keySet = ht.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next + "," + ht.get(next));
        }

        System.out.println("----------");

        // 第三种遍历方式 : 返回value集
        Collection<Integer> values = ht.values();
        Iterator<Integer> it2 = values.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

        System.out.println("----------");

        // 第四种遍历方式 : 返回key-value集
        Set<Map.Entry<String, Integer>> entrySet = ht.entrySet();
        Iterator<Map.Entry<String, Integer>> it3 = entrySet.iterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }
    }
}
