package cn.com.clearlight.setframe.set;

import cn.com.clearlight.setframe.set.bean.Student;
import cn.com.clearlight.setframe.set.comparator.ComparatorByName;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetForCompare {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>(new ComparatorByName());
        ts.add(new Student("ac", 1));
        ts.add(new Student("a", 1));
        ts.add(new Student("d", 4));
        ts.add(new Student("d", 4));
        ts.add(new Student("ab", 3));
        ts.add(new Student("ab", 1));

        Iterator<Student> iterator = ts.iterator();

        for (Student s :
                ts) {
            System.out.println(s.getName() + ":" + s.getAge());
        }
    }
}
