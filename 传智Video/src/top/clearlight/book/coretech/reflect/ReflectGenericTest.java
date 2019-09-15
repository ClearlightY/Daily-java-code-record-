package top.clearlight.book.coretech.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过反射获取类中的泛型类型
 */
public class ReflectGenericTest {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Method method = MyClass.class.getMethod("getString", null);

        Type returnType = method.getGenericReturnType();

        // 获取泛型方法返回类型
        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass=" + typeArgClass);
            }
        }

        // 获取泛型方法返回类型
        method = MyClass.class.getMethod("setStringList", List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType aType = (ParameterizedType) genericParameterType;
                Type[] parameterArgTypes = aType.getActualTypeArguments();
                for (Type parameterArgType : parameterArgTypes) {
                    Class parameterArgClass = (Class) parameterArgType;
                    System.out.println("parameterArgClass=" + parameterArgClass);
                }
            }
        }

        // 获取泛型变量类型
        Field field = MyClass.class.getField("stringList");
        Type genericFieldType = field.getGenericType();

        if (genericFieldType instanceof ParameterizedType) {
            ParameterizedType aType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            for (Type fieldArgType : fieldArgTypes) {
                Class fieldArgTypes2 = (Class) fieldArgType;
                System.out.println("fieldArgClass=" + fieldArgTypes2);
            }
        }

    }
}

class MyClass {
    public List<String> stringList = new ArrayList<>();


    public List<String> getString() {
        return this.stringList;
    }

    public void setStringList(List<String> list) {
        this.stringList = list;
    }
}