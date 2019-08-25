package top.clearlight.wechat.map;

import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> tm = new TreeMap();
        tm.put(1, 2);
        tm.put(4, 5);
        tm.put(2, 3);
        // 允许value为 null
        tm.put(3, null);
        tm.put(9, null);
        // 不允许key为 null
        // tm.put(null, 3);

        System.out.println(tm);
        System.out.println(tm.firstKey());
        System.out.println(tm.lastKey());

        Set<Integer> keySet = tm.keySet();
        Iterator<Integer> it = keySet.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            System.out.println(next + "," + tm.get(next));
        }

        Collection<Integer> values = tm.values();
        Iterator<Integer> it2 = values.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

        Set<Map.Entry<Integer, Integer>> entrySet = tm.entrySet();
        Iterator<Map.Entry<Integer, Integer>> it3 = entrySet.iterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }


    }
}
