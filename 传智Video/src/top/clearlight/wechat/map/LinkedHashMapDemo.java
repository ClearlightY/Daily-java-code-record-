package top.clearlight.wechat.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 键和值都允许为空
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, Player> lhm = new LinkedHashMap<>();
        lhm.put("东", new Player("张三"));
        lhm.put("西", new Player("李四"));
        lhm.put("南", new Player("王五"));
        lhm.put("北", new Player("刘六"));
        lhm.put(null, new Player(null));
        lhm.put("?", null);

        System.out.println(lhm);
        lhm.get("北");
        lhm.remove("西");

        Set<Map.Entry<String, Player>> entrySet = lhm.entrySet();
        Iterator<Map.Entry<String, Player>> it = entrySet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
       /* for (Map.Entry<String, Player> stringPlayerEntry : entrySet) {
            System.out.println(stringPlayerEntry);
        }*/

        for (Map.Entry<String, Player> next : entrySet) {
            System.out.println(next.getKey() + "," + next.getValue());
        }

        Set<String> keySet = lhm.keySet();
        Iterator<String> it2 = keySet.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            System.out.println(next + " = " + lhm.get(next));
        }

        Iterator<Player> it3 = lhm.values().iterator();
        while (it3.hasNext()) {
            System.out.println("values is " + it3.next());
        }
    }
}
