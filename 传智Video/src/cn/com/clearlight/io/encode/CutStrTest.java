package cn.com.clearlight.io.encode;

import java.io.UnsupportedEncodingException;

public class CutStrTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "ab你好cd顶馈";

        int len = str.getBytes("gbk").length;

        for (int x = 0; x < len; x++) {
            System.out.println("截取" + (x + 1) + "个字节结果是 : " + cutStringByBytes(str, x + 1));
        }
    }

    /**
        在Java中,字符串"abcd"与字符串"ab你好"的长度是一样的,都是四个字符
        但对应的字节数不同,一个汉字占两个字节
        定义一个方法,按照最大的字节数来取子串
        如 : 对于"ab你好", 如果取三个字节,那么子串就是ab与"你"的半个,
        那么半个就要舍弃.
        如果取四个字节就是"ab你", 取五个字节还是"ab你"
     */
    private static String cutStringByBytes(String str, int len) throws UnsupportedEncodingException {
        byte[] buf = str.getBytes("gbk");

        int count = 0;
        for (int x = len - 1; x >= 0; x--) {
            if (buf[x] < 0) {
                count++;
            } else {
                break;
            }
        }
        if (count % 3 == 0) {
            return new String(buf, 0, len, "gbk");
        } else {
            return new String(buf, 0, len - 1, "gbk");
        }
    }
}

   /* private static String cutStringUtfByBytes(String str, int len) throws UnsupportedEncodingException {
        byte[] buf = str.getBytes("utf-8");

        int count = 0;
        for (int x = len - 1; x >= 0; x--) {
            if (buf[x] < 0) {
                count++;
            } else {
                break;
            }
        }
        if (count % 3 == 0) {
            return new String(buf, 0, len, "utf-8");
        } else if (count % 3 == 1) {
            return new String(buf, 0, len - 1, "utf-8");
        } else {
            return new String(buf, 0, len - 2, "utf-8");
        }
    }*/
