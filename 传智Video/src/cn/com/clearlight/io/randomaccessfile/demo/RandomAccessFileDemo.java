package cn.com.clearlight.io.randomaccessfile.demo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.RandomAccess;

public class RandomAccessFileDemo {
    /**
     * RandomAccessFile
     * <p>
     * 特点 :
     * 1. 该对象既能读,又能写
     * 2. 该对象内部维护了一个byte数组,并通过指针可以操作数组中的元素
     * 3. 可以通过getFilePointer方法获取指针的位置,和通过seek方法设置指针的位置
     * 4. 其实该对象就是将字节输入流和输出流进行了封装.
     * 5. 该对象的源或者目的只能是文件.通过构造函数就可以看出.
     */

    public static void main(String[] args) throws IOException {
        // writeFile();
        // readFile();
        randomWrite();
        byte[] bytes = "张三".getBytes();
        System.out.println(Arrays.toString(bytes));
    }

    private static void readFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("randomaf.txt", "r");
        // seek : 设置指针的位置
        raf.seek(10); // 随机读取. 只要指定指针的位置即可
        byte[] buf = new byte[6];
        raf.read(buf);

        String name = new String(buf);
        int age = raf.readInt();

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("pos = " + raf.getFilePointer());

        raf.close();
    }

    // 使用RandomAccessFile对象写入一些人员信息,比如姓名和年龄
    public static void writeFile() throws IOException {
        /*
        如果文件不存在,则创建,如果文件存在,则不创建
         */
        RandomAccessFile raf = new RandomAccessFile("randomaf.txt", "rw");

        raf.write("张三".getBytes());
        raf.writeInt(609);
        raf.write("李强".getBytes());
        raf.writeInt(98);
        raf.close();
    }

    public static void randomWrite() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("randomaf.txt", "rw");

        // 往指定位置写入数据
        raf.seek(3 * 8);

        raf.write("喜喜".getBytes());
        raf.write(109);

        raf.close();
    }
}
