package cn.com.clearlight.setframe.map.demo;

import java.util.*;

public class HashMapDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arrStr = s.split("");
        List list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            list.add(arrStr[i]);
        }
        System.out.println(list);
        HashMap hm = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            if (hm.containsKey(list.get(i))) {
                int val = (Integer) hm.get(list.get(i)) + 1;
                hm.put(list.get(i), val);
            } else {
                hm.put(list.get(i), 1);
            }
        }
        Iterator<Map.Entry> it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry me = it.next();
            System.out.print(me.getKey() + "(" + me.getValue() + ")");
        }
    }
}
