package top.clearlight.book.coretech.reflect;

import java.lang.reflect.*;
import java.util.Arrays;

public class PeopleReflectTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<People> clazz = People.class;
        int modifiers = clazz.getModifiers();
        System.out.println(modifiers);

        String name = clazz.getName();
        System.out.println(name);
        String simpleName = clazz.getSimpleName();
        System.out.println(simpleName);

        Class<? super People> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        People p = new People();
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(p, "Jack");
        System.out.println(p.getName());

        Field sex = clazz.getDeclaredField("sex");
        sex.set(null, "girl");
        System.out.println(People.sex);

        Field ageField = clazz.getField("age");
        Class<?> type = ageField.getType();
        System.out.println(type);
        String name1 = ageField.getName();
        System.out.println(name1);

        // 获取所有构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("构造器:" + declaredConstructor);
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
        }

        System.out.println("--------------");
        /*
        获取公有构造器
         */
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        /*
        对特定的构造器实例化对象
         */
        Constructor<People> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        People mary = declaredConstructor.newInstance("Mary", 18);
        System.out.println(mary);

        System.out.println("-----------------");

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("------------------");

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("方法名:" + declaredMethod.getName());
            int modifiers1 = declaredMethod.getModifiers();
            System.out.println("修饰符:" + modifiers);
            System.out.println("返回类型:" + declaredMethod.getReturnType());
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            System.out.println("参数列表:");
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
            System.out.println();
        }

        Constructor<People> declaredConstructor1 = People.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor1.setAccessible(true);
        People p2 = declaredConstructor1.newInstance("Bob", 21);
        p.setAge(23);


        Method compareTo = clazz.getMethod("compareTo", People.class);
        Object comPareMethod = compareTo.invoke(p, p2);
        System.out.println(comPareMethod);

        // 创建int类型的数组,长度为10
        int[] ints = (int[]) Array.newInstance(int.class, 10);
        System.out.println(Arrays.toString(ints));

        int[][] ints1 = (int[][]) Array.newInstance(int[].class, 3);
        System.out.println("-----------");
        for (int[] ints2 : ints1) {
            System.out.println(Arrays.toString(ints2));
        }

        // int[] ints2 = (int[]) Array.newInstance(int[].class.getComponentType(), 10);
        // System.out.println(Arrays.toString(ints2));
        Class<?> componentType = int[][].class.getComponentType();
        System.out.println(componentType); // class [I

        Array.set(ints, 3, 18);
        int i = (int) Array.get(ints, 3);
        System.out.println(i);

        String[] strArr = new String[10];
        String[][] strTwoArr = (String[][]) Array.newInstance(strArr.getClass(), 5);
        System.out.println(Arrays.toString(strTwoArr));

        String[] strings = (String[]) Array.get(strTwoArr, 4);
     /*   String[] strings1 = (String[]) Array.newInstance(strings.getClass().getComponentType(), 10);
        System.out.println(Arrays.toString(strings1));*/

        String[][] strArrT = (String[][]) Array.newInstance(String[].class.getComponentType(), 5, 10);
        System.out.println(Arrays.toString(strArrT));

        int[][] ints2 = (int[][]) Array.newInstance(int.class, 5, 10);
        System.out.println(Arrays.toString(ints2));
        int[] ints3 = (int[]) Array.get(ints2, 3);
        Array.set(ints3, 5, 21);

        for (int[] ints4 : ints2) {
            System.out.println(Arrays.toString(ints4));
        }


        // 泛型测试
        Method getStringList = People.class.getMethod("getStringList", null);

        Type genericReturnType = getStringList.getGenericReturnType();

        if (genericReturnType instanceof ParameterizedType) {
            ParameterizedType type1 = (ParameterizedType) genericReturnType;
            Type[] actualTypeArguments = type1.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }


    }
}

