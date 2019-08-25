package top.clearlight.coretech.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<ReflectTest2> reflectTest2Class = ReflectTest2.class;
        System.out.println(reflectTest2Class.getName());
        ReflectTest2 reflectTest21 = reflectTest2Class.newInstance();
        System.out.println(reflectTest21);

        Class<Integer> integerClass = Integer.class;
        System.out.println(integerClass.getName());
        Integer integer = integerClass.newInstance();
        System.out.println(integer);

        Class<Integer> integerClass1 = int.class;
        System.out.println(integerClass1.getName());

        Class<Integer> type = Integer.TYPE;
        System.out.println(type.getName());

        // Class<?> aClass = Class.forName("top.clearlight.coretech.reflect.ReflectTest2");
        Class<?> aClass = Class.forName(ReflectTest2.class.getName());
        Object o = aClass.newInstance();
        System.out.println(aClass.getName());
        System.out.println("--------" + o);

        ReflectTest2 rt2 = new ReflectTest2();
        Class<? extends ReflectTest2> aClass1 = rt2.getClass();
        System.out.println(aClass1.getName());
        ReflectTest2 reflectTest2 = aClass1.newInstance();
        System.out.println(reflectTest2);

        /*Class<Void> voidClass = void.class;
        System.out.println(voidClass.getName());
        Void aVoid = voidClass.newInstance();
        System.out.println(aVoid);*/

        Constructor<ReflectTest2> declaredConstructor = ReflectTest2.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        ReflectTest2 reflectTest22 = declaredConstructor.newInstance();
        System.out.println(reflectTest22);
    }
}
