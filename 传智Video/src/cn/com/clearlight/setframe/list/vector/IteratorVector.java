package cn.com.clearlight.setframe.list.vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class IteratorVector {
    public static void main(String[] args) {
        Vector vector = new Vector(5);

        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

        System.out.println("Enumeration遍历方式:");
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }

        System.out.println("Iterator迭代方式遍历: ");
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("快速访问方式遍历: ");
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }

        System.out.println("foreach方式遍历: ");
        for (Object i :
                vector) {
            System.out.println(i);
        }

        ListIterator listIterator = vector.listIterator();
        System.out.println("ListIterator向后迭代方式遍历: ");

        listIterator.next();
        listIterator.next();
        System.out.println(listIterator.nextIndex());
        listIterator.add(999);
        System.out.println(listIterator.nextIndex() + "cursionIndex");

        while (listIterator.hasNext()) {
            System.out.println(listIterator.nextIndex() + "/");
            System.out.println(listIterator.next());
            System.out.println(listIterator.previousIndex() + "pre/");

        }
        System.out.println("ListIterator向前迭代方式遍历: ");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        System.out.println("------------------");
        listIterator.next();
        listIterator.next();
        listIterator.set(10);
       /* listIterator.remove();
        listIterator.remove();*/
        listIterator.previous();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
//            System.out.println(listIterator.nextIndex() + "/");

        }
    }
}
