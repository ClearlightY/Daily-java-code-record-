package top.clearlight.wechat.map2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Lisa", 18);
        hm.put("Jack", 28);
        hm.put("Mike", 13);
        hm.put("Bob", 19);

        System.out.println(hm.containsKey("Lisa"));
        System.out.println(hm.containsValue(19));

        System.out.println(hm);

        Set<String> keySet = hm.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next + "=" + hm.get(next));
        }

        Iterator<Integer> it2 = hm.values().iterator();
        while (it2.hasNext()) {
            System.out.println("value : " + it2.next());
        }

        Iterator<Map.Entry<String, Integer>> it3 = hm.entrySet().iterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }
    }
}
