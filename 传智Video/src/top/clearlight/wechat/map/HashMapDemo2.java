package top.clearlight.wechat.map;

import java.util.*;

public class HashMapDemo2 {
    public static void main(String[] args) {
        Map hm = new HashMap<>();
        hm.put("姓名", "Jack");
        hm.put("age", 18);
        hm.put("身高", '?');
        hm.put("身高", 178);
        // 键和值都允许为 null
        hm.put(null, null);

        // 第一种遍历方式 : 直接输出该对象
        System.out.println("直接打印");
        System.out.println(hm);

        // 第二种遍历方式 : 通过返回键集
        System.out.println("keySet()");
        Set keySet = hm.keySet();
        Iterator iter = keySet.iterator();
        while (iter.hasNext()) {
            Object next = iter.next();
            System.out.println(next + "," + hm.get(next));
        }

        /*
		首先返回的都是集合类型,除了可以使用iterator进行遍历外,还可以使用增强for循环也是非常方便的.
		其实增强for循环就是上面形式的简写.本质也是上面的形式.
		*/
        // 增强for循环
        System.out.println("增强for循环");
        for (Object s :
                keySet) {
            System.out.println(s + "," + hm.get(s));
        }

        // 第三种遍历方式 : 通过返回值集
        System.out.println("value()");
        Collection values = hm.values();
        Iterator iter1 = values.iterator();
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }

        // 第四种遍历方式 : 通过返回key-value集
        System.out.println("entrySet()集");
        Iterator iter2 = hm.entrySet().iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }

        /*
        第四种方式的细化,将返回的key-value集分别取出
         */
        while (iter2.hasNext()) {
            Map.Entry next = (Map.Entry) iter2.next();
            System.out.println(next.getKey() + " . " + next.getValue());
        }

        /*
        第四种方式细化的简化形式.
         */
        Set<Map.Entry> entrySet = hm.entrySet();
        for (Map.Entry e : entrySet) {
            System.out.println(e.getKey() + " , " + e.getValue());
        }
    }
}
