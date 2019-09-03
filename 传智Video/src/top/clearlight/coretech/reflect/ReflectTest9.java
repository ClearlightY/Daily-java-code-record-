package top.clearlight.coretech.reflect;

import java.lang.reflect.Array;

public class ReflectTest9 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("[I");
        Class<int[]> aClass1 = int[].class;
        System.out.println(aClass);
        System.out.println(aClass1);
        // boolean array = aClass.isArray();
        // System.out.println(array);

        String[][] strings = (String[][]) Array.newInstance(Class.forName("[Ljava.lang.String;"), 10);
       /* Array.set(strings, 2, "12");
        System.out.println(Arrays.toString(strings));*/

        int[] dims = new int[] { 5, 10, 15 };

        // 注意区分下面两种
        System.out.println(Integer.TYPE);    // int
        System.out.println(Integer.class);    // Integer

        // 创建一个三维数组，这个数组的三个维度分别是5,10,15
        Object array = Array.newInstance(Integer.TYPE, dims);
        // 可变参数，也可以这样写：
        // Object array = Array.newInstance(Integer.TYPE, 5,10,15);

        System.out.println(array instanceof int[][][]);

        Class<?> classType0 = array.getClass().getComponentType();    // 返回数组元素类型
        System.out.println(classType0);    // 三维数组的元素为二维数组，输出：class [[I

        // 获得第一层的索引为3的数组，返回的是一个二维数组
        Object arrayObject = Array.get(array, 3);
        Class<?> classType = arrayObject.getClass().getComponentType();    // 返回数组元素类型
        System.out.println(classType);    // 二维数组的元素为一维数组，输出：class [I

        // 此处返回的是一个一维数组
        arrayObject = Array.get(arrayObject, 5);
        Class<?> classType2 = arrayObject.getClass().getComponentType();    // 返回数组元素类型
        System.out.println(classType2);    // 一维数组的元素为int

        // 给一维数组下标为10的位置设置值为37
        Array.setInt(arrayObject, 10, 37);

        int[][][] arrayCast = (int[][][]) array;
        System.out.println(arrayCast[3][5][10]);
    }
}
