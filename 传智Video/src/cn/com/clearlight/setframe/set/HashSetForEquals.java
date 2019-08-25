package cn.com.clearlight.setframe.set;

import cn.com.clearlight.setframe.set.bean.Student;

import java.util.HashSet;

public class HashSetForEquals {
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();

        hs.add(new Student("a", 1));
        hs.add(new Student("a", 1));
        hs.add(new Student("ab", 1));

        for (Student s :
                hs) {
            System.out.println(s.getName() + " : " + s.getAge());
        }
    }
}
