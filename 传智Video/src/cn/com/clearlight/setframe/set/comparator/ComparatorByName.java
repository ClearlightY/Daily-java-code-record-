package cn.com.clearlight.setframe.set.comparator;

import cn.com.clearlight.setframe.set.bean.Student;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int temp = o1.getName().compareTo(o2.getName());
        return temp == 0 ? o1.getAge() - o2.getAge() : temp;
    }
}
