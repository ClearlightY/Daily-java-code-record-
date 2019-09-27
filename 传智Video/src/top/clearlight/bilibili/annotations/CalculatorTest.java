package top.clearlight.bilibili.annotations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalculatorTest {
    public static void main(String[] args) throws IOException {
        Calculator cal = new Calculator();
        Class<? extends Calculator> cls = cal.getClass();
        Method[] methods = cls.getDeclaredMethods();

        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        // 出现异常的个数
        int num = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(cal);
                } catch (Exception e) {
                    bw.write(method.getName() + "方法报错");
                    bw.newLine();
                    bw.write("错误原因:" + e.getCause().getMessage());
                    bw.newLine();
                    num++;
                }
            }
        }

        bw.write("-----------------");
        bw.newLine();
        bw.write("出现" + num + "个异常");

        bw.flush();
        bw.close();

    }
}
