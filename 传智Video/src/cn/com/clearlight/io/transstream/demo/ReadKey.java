package cn.com.clearlight.io.transstream.demo;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读取键盘录入输出到控制台
 */
public class ReadKey {
    public static void main(String[] args) throws IOException {
        // System.out.println((int) '\r');
        // System.out.println((int) '\n');
        // readKey_1();
        // readKey_2();
        readKey_3();
    }

    /**
     * 获取用户键盘录入的数据
     * 并将数据变成大写显示在控制台上
     * 如果用户输入的时over,结束键盘录入
     * <p>
     * 思路:
     * 1. 因为键盘录入只读取一个字节,要判断是否是over,需要将读取到的字节拼成字符串
     * 2. 需要一个容器. StringBuilder
     * 3. 在用户回车之前将录入的数据变成字符串判断即可
     */
    private static void readKey_3() throws IOException {
        InputStream in = System.in;

        StringBuilder sb = new StringBuilder();

        /*while (sb.append(in.read()).toString().equals("over")) {
            System.out.println(sb.toString().toUpperCase());
        }*/
        int ch = 0;
        while ((ch = in.read()) != -1) {
            /*if (ch == '\r') {
                continue;
            }*/
            if (ch == '\n') {
                if ("over".equals(sb.toString())) {
                    return;
                }
                System.out.print(sb.toString().toUpperCase());
                sb.delete(0, sb.length());
            } else {
                sb.append((char) ch);
            }

        }
    }

    /**
     * 读取键盘的输入知道读取完为止,继续下一次的输入读取
     *
     * @throws IOException
     */
    private static void readKey_2() throws IOException {
        InputStream in = System.in;
        int ch = 0;
        while ((ch = in.read()) != -1) {
            System.out.println("ch = " + ch);
        }
    }

    /**
     * 一次读取一个键盘输入
     *
     * @throws IOException
     */
    private static void readKey_1() throws IOException {
        InputStream in = System.in;
        int ch = in.read();
        System.out.println("ch = " + ch);
        int ch1 = in.read();
        System.out.println("ch1 = " + ch1);
        int ch2 = in.read();
        System.out.println("ch2 = " + ch2);
    }
}
