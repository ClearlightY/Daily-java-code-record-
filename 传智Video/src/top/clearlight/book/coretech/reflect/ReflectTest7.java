package top.clearlight.book.coretech.reflect;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectTest7 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<People> peopleClass = People.class;
        Constructor<People> constructor = peopleClass.getConstructor();
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        System.out.println(Arrays.toString(parameterTypes));
        System.out.println(parameterTypes);
        System.out.println(constructor.getName());
        System.out.println(constructor.getModifiers());
        System.out.println(constructor/*lass<?> intcompon = int[].class.getComponentType();
        Object o = intcompon.newInstance();
        int[] o1 = (int[]) o;
        System.out.println(o1);*/.toString());

        Constructor<People> constructor1 = peopleClass.getConstructor(String.class);
        System.out.println(constructor1.toString());

        // 构造函数如果不是public修饰的，那么只能用getDeclaredConstructor方法
        Constructor<People> declaredConstructors = peopleClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructors.toString());
        // 创建私有构造函数必须将acess设置为true
        declaredConstructors.setAccessible(true);
        People p = declaredConstructors.newInstance("jack", 18);
        System.out.println(p);

        Class<People> declaringClass = declaredConstructors.getDeclaringClass();
        System.out.println(declaringClass.getName());
        Method method = declaringClass.getMethod("setAge", int.class);
        System.out.println("方法名：" + method.getName());
        System.out.println("修饰符：" + method.getModifiers());
        System.out.println("描述参数类型的数组：" + method.getParameterTypes());
        Class<?>[] methodPT = method.getParameterTypes();
        System.out.println(Arrays.toString(methodPT));
        System.out.println("方法的返回值:" + method.getReturnType());

        Class<ReflectTest7> reflectTest7Class = ReflectTest7.class;
        Class<?> componentType = reflectTest7Class.getComponentType();
        // System.out.println(componentType.getName());componentType1

        System.out.println(int[].class.getComponentType());
        // Class<?> intcompon = int[].class.getComponentType();
        // Object o = intcompon.newInstance();
        // int[] o1 = (int[]) o;
        // System.out.println(o1);

        People people = People.class.newInstance();
        System.out.println(people+"?");

        Field name = People.class.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.getName());
        System.out.println(name);
        name.set(people, "Marry");
        System.out.println(people.getName());

        Object o = name.get(people);
        System.out.println(o.toString());

        Field age = People.class.getDeclaredField("age");
        age.set(people, 18);
        System.out.println(people.getAge());
        // 反编译后的代码
        // int o1 = (Integer)age.get(people);
        int o1 = (int) age.get(people);
        System.out.println(o1);

        Method setAge = People.class.getMethod("setAge", int.class);
        String name1 = setAge.getName();
        System.out.println(name1);
        System.out.println(setAge.getReturnType());
        Class<?>[] paraTypes = setAge.getParameterTypes();
        System.out.println(Arrays.toString(paraTypes));
        System.out.println(setAge.getDeclaringClass());

        // 通过获取的方法来重新类的对象
        Class<?> declaringClass1 = setAge.getDeclaringClass();
        String name2 = declaringClass1.getName();
        System.out.println(name2);

        Method[] methods = People.class.getMethods();
        for (Method method1 : methods) {
            System.out.println(method1.toString());
            Class<?>[] parameterTypes1 = method1.getParameterTypes();
            System.out.println(Arrays.toString(parameterTypes1));

            int modifiers = method1.getModifiers();
            System.out.println(modifiers);
        }

        Method getAge = People.class.getMethod("getAge");


        Class<String[]> aClass = String[].class;
        Class<?> componentType1 = String[].class.getComponentType();
        System.out.println(aClass.equals(componentType1));
        System.out.println(aClass.getName());
        System.out.println(componentType1.getName());

        // String[] strings = String[].class.newInstance();
        // System.out.println(strings);

        String s = String.class.newInstance();
        System.out.println(s);
        String[] strings = (String[]) Array.newInstance(String.class, 10);
        Array.set(strings, 3, "hahaha");
        System.out.println(Arrays.toString(strings));
        System.out.println(strings.toString());


    }
}
