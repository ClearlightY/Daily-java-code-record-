package top.clearlight.coretech.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 通过输入全限定类名来输出类的结果.包括所有的域,方法和构造器.
 *
 * @author Clearlight
 * @date 2019.08.25
 */
public class ReflectTest6 {
    public static void main(String[] args) {
        // read class name from command line args or user input
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.tuil.Date): ");
            name = in.next();
        }

        try {
            // print class name and superclass name (if != Object)
            Class c1 = Class.forName(name);
            Class superc1 = c1.getSuperclass();
            // 获取类的修饰符和权限符
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + c1.getSimpleName());
            if (superc1 != null && superc1 != Object.class) {
                System.out.print(" extends " + superc1.getName());
            }

            System.out.print("\n{\n");
            printConstructors(c1);
            System.out.println();
            printMethods(c1);
            System.out.println();
            printFilelds(c1);
            System.out.println("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * Prints all fields of a class
     *
     * @param c1 a class
     */
    private static void printFilelds(Class c1) {
        Field[] fields = c1.getDeclaredFields();

        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    /**
     * Prints all methods of a class
     *
     * @param c1 a class
     */
    private static void printMethods(Class c1) {
        Method[] methods = c1.getDeclaredMethods();
        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("   ");

            // print modifiers, return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(retType.getName() + " " + name + "(");
            Class[] paramTypes = m.getParameterTypes();
            getParamType(paramTypes);
        }
    }

    /**
     * print parameter types
     *
     * @param paramTypes a Method
     */
    private static void getParamType(Class[] paramTypes) {
        for (int j = 0; j < paramTypes.length; j++) {
            if (j > 0) {
                System.out.print(", ");
            }
            System.out.print(paramTypes[j].getName());
        }
        System.out.println(");");
    }


    /**
     * Prints all constructors of a class
     *
     * @param c1 a class
     */
    private static void printConstructors(Class c1) {
        Constructor[] constructors = c1.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            // print parameter types
            Class[] paramTypes = c.getParameterTypes();
            getParamType(paramTypes);
        }
    }
}
