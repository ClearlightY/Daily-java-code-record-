package cn.com.clearlight.setframe.list.vector;

import org.junit.jupiter.api.Test;

import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        Vector v = new Vector();

        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");

        // 遍历Vector数组的两种方式
        Enumeration elements = v.elements();
        while (elements.hasMoreElements()) {
            System.out.println("v.element : " + elements.nextElement());
        }

        Iterator iterator = v.iterator();
        while (iterator.hasNext()) {
            System.out.println("v.element : " + iterator.next());
        }

        Vector vector = new Vector(20);

        vector.add("a");
        vector.addElement("b");
        vector.addElement("c");
        vector.addElement("d");

        // 返回vector的容量 : 20
        System.out.println(vector.capacity());
        // 返回vector的实际大小 : 4
        System.out.println(vector.size());

        System.out.println(vector.elements());

        String[] s = new String[vector.size()];
        s = (String[]) vector.toArray(s);
        System.out.println("s : " + Arrays.toString(s));

        /*Integer[] arrInt = new Integer[4];
        arrInt = (Integer[]) vector.toArray(arrInt);
        System.out.println(Arrays.toString(arrInt));*/

        Object[] obj = vector.toArray();
        System.out.println("obj : " + Arrays.toString(obj));

      /*  s = (String[]) vector.toArray();
        System.out.println(Arrays.toString(s));*/
        System.out.println((Object) vector.getClass());
        List list = new ArrayList();
        System.out.println((Object) list.getClass());
        System.out.println(vector.getClass().getComponentType());
        String[] i = new String[10];
        // System.out.println((String) i.getClass() == (String)String[].class);
        System.out.println("----");
        System.out.println(i.getClass());
        System.out.println(i.getClass().getComponentType());

        testVector();

        try {
            if (1 > 0) {
                System.out.println("try");
            }
        } finally {
            System.out.println("finally");
        }

        int a = 1;
        Integer integer = new Integer(1);
        System.out.println(integer.equals(a));

        List testList = new ArrayList();
        testList.add("1");
        testList.add("2");
        testList.add("3");
        testList.add("4");
        System.out.println(v.equals(testList));

        ListIterator listIterator = v.listIterator();

    }

    @Test
    public static void testVector() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Vector vector = new Vector(list);
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Integer[] object = new Integer[vector.size()];
        vector.copyInto(object);
        System.out.println(Arrays.toString(object));

        int[] testInt = new int[3];
        for (int i = 0; i < 3; i++) {
            testInt[i] = i;
        }
        int[] copyInt = Arrays.copyOf(testInt, 5);
        System.out.println("copytInt : " + Arrays.toString(copyInt));
        testInt[2] = 0;
        System.out.println("copytInt : " + Arrays.toString(copyInt));

        /*String a = null;
        System.out.println(a.equals("a"));*/
        Object v = vector.clone();
        v = "";
        System.out.println(v);
        String string = v.toString();
        System.out.println(string);

        Iterator iter = vector.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}

class a {
    int a = 1;

}

class b {
    int b = 2;
}
