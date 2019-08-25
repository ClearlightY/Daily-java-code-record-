package cn.com.clearlight.setframe.set.demo;

import cn.com.clearlight.setframe.set.bean.Student;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
//        hashSet();
        hashSet2();
    }

    public static void hashSet2() {
        HashSet<Student> hs = new HashSet<>();
        hs.add(new Student("zhangsan", 10));
        hs.add(new Student("lisi", 11));
        hs.add(new Student("wangwu", 12));
        hs.add(new Student("liuliu", 13));
        hs.add(new Student("zhouwu", 14));
        hs.add(new Student("lisi", 11));

        Iterator<Student> iterator = hs.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            System.out.println(s.getName() + ":" + s.getAge());
        }
    }

    public static void hashSet() {
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(1);
//        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);

        Object obj = hashSet.clone();
        System.out.println(obj);

        System.out.println(hashSet.contains(3));

        System.out.println(hashSet.isEmpty());

        Iterator<Integer> iterator = hashSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(hashSet.size());

        hashSet.clear();

        System.out.println(hashSet.size());
    }
}
