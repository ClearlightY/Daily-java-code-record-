package top.clearlight.book.coretech.reflect;

import java.lang.reflect.InvocationTargetException;

public class ReflectTest5 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass1 = Class.forName("java.lang.String");
        System.out.println(aClass1.getName());
        Object o = aClass1.newInstance();
        // int[][] i = (int[][])o;


        Class<int[]> aClass = int[].class;
        System.out.println(aClass.getName());

        System.out.println(String.class == Class.forName("java.lang.String"));
        System.out.println(int.class.getName());
        System.out.println(String.class.getName());
        // System.out.println(Class.forName(int.class.getName()));

        try {
            String s = String.class.getDeclaredConstructor().newInstance();
            System.out.println(s.toString());
            System.out.println(s);
            System.out.println("????????");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String str = new String();
        System.out.println(str);

        System.out.println("----------------");
    }
}
