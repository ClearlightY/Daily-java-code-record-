package cn.com.clearlight.io.encode;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {

        /*
        字符串 --> 字符数组 : 编码
        字符数组 -- > 字符串 : 解码
        你好 :
        utf-8 : -28 -67 -96 -27 -91 -67
        gbk
         */
        String str = "你好";

        // 编码
        byte[] buf = str.getBytes("gbk");

        // 解码 : 识别错误的字符串
        String s1 = new String(buf, "iso8859-1");

        System.out.println("s1 = " + s1);

        // 重新编码为字符数组
        byte[] buf2 = s1.getBytes("iso8859-1");
        // 以正确的方式进行解码
        String s2 = new String(buf2, "gbk");
        System.out.println("s2 = " + s2);

        // printBytes(buf);
    }

    private static void printBytes(byte[] buf) {
        for (byte b : buf) {
            System.out.println(b);
        }
    }
}
