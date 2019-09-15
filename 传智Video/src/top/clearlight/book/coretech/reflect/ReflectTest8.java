package top.clearlight.book.coretech.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectTest8 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> componentType = String[].class.getComponentType();
        System.out.println(componentType.getName());
        System.out.println(String[].class.getName());
        Class<?> componentType1 = String.class.getComponentType();
        System.out.println(componentType1);

        // 创建一个Stirng类型的无参构造实例
        Constructor<String> declaredConstructor = String.class.getDeclaredConstructor();
        String s = declaredConstructor.newInstance();
        System.out.println(s);

        // 创建一个String类型的有参构造实例
        Constructor<String> declaredConstructor1 = String.class.getDeclaredConstructor(String.class);
        String jack = declaredConstructor1.newInstance("jack");
        System.out.println(jack);

/*        Constructor<String[]> declaredConstructor2 = String[].class.getDeclaredConstructor();
        String[] strings = declaredConstructor2.newInstance();
        System.out.println(strings);*/

        String[] strArr = (String[]) Array.newInstance(String[].class.getComponentType(), 10);
        System.out.println(Arrays.toString(strArr));
        // System.out.println(Array.class.getName());
        Array.set(strArr, 3, "jack");
        System.out.println(Arrays.toString(strArr));
        String o = (String)Array.get(strArr, 3);
        System.out.println(o);

        Object o1 = Array.newInstance(int[].class.getComponentType(), 5);
        int[] intArr = (int[]) o1;
        Array.setInt(intArr, 3, 10);
        System.out.println(Arrays.toString(intArr));
        int i = (int) Array.get(intArr, 3);
        System.out.println(i);

        System.out.println(Array.getLength(o1));

        // 获得Math类中的sqrt方法
        Method sqrt = Math.class.getMethod("sqrt", double.class);
        // 调用sqrt方法，并且传入参数，返回特定的值
        Object invoke = sqrt.invoke(null, 9);
        System.out.println(invoke);

        // 调用非静态方法，需要向invoke方法中传入对象
        ArrayList arrList = new ArrayList();
        Method add = ArrayList.class.getMethod("add", Object.class);
        // 调用add方法
        Object invoke1 = add.invoke(arrList, "hahaha");
        add.invoke(arrList,"xixix");
        System.out.println(invoke1);
        System.out.println(arrList);

        // 打印ArrayList的方法名
        Method[] methods = ArrayList.class.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println(ReflectTest8.class.getPackage().getName());

        Package aPackage = Math.class.getPackage();

        // 获取父类
  /*      String name = List.class.getSuperclass().getName();
        System.out.println(name);*/
        Class<? super List> superclass = List.class.getSuperclass();
        System.out.println(superclass);

        Class<?>[] interfaces = Byte.class.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }

        Annotation[] annotations = ArrayList.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Class[] classes = new Class[]{String.class, int.class, Array.class, int[].class};
        System.out.println(Arrays.toString(classes));

        Constructor<String> constructor = String.class.getConstructor(int[].class, int.class, int.class);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType);
        }

        System.out.println("----------------");

        
    }
}
