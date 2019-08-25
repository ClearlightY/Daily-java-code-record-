package cn.com.clearlight.io.encode;

import java.io.UnsupportedEncodingException;

public class LianTong {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "联通";
        /*
        联通被认为是utf-8的编码
            11000001
            10101010
            11001101
            10101000
         */
        byte[] buf = str.getBytes("gbk");

        for (byte b :
                buf) {
            System.out.println(Integer.toBinaryString(b & 255));
        }
    }
}
