package cn.com.clearlight.io.properties.demo;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        /**
         * Map
         *  |--HashTable
         *      |--Properties
         * Properties集合:
         * 特点:
         * 1. 该集合的键和值都是字符串类型
         * 2. 集合中的数据可以保存到流中,或者从流获取
         *
         * 通常该集合用于操作以键值对形式存在的配置文件
         */
        // propertiesDemo();
        // propertiesDemo_2();
        // propertiesDemo_3();
        // propertiesDemo_4();
        test();
    }

    private static void test() throws IOException {
        // 读取这个文件
        File file = new File("info.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fr = new FileReader("info.txt");

        // 创建集合存储配置信息
        Properties prop = new Properties();

        // 将流中信息存储到集合中
        prop.load(fr);

        prop.setProperty("wangwu", "100");

        FileWriter fw = new FileWriter(file);

        prop.store(fw, "");

        // prop.list(System.out);
        fw.close();
        fr.close();
    }

    private static void propertiesDemo_4() throws IOException {
        Properties prop = new Properties();

        // 集合中的数据来自于一个文件
        // 注意: 必须要保证该文件中的数据是键值对
        // 需要使用到读取流
        FileInputStream fis = new FileInputStream("info.txt");

        // 使用load方法
        prop.load(fis);

        prop.list(System.out);
    }

    private static void propertiesDemo_3() throws IOException {
        Properties prop = new Properties();

        // 存储元素
        prop.setProperty("zhangsan", "30");
        prop.setProperty("lisi", "20");
        prop.setProperty("wangwu", "33");
        prop.setProperty("liuliu", "10");
        prop.setProperty("wuil", "90");

        // 想要将这些集合中的字符串键值信息持久化存储到文件中
        // 需要关联输出流
        FileOutputStream fos = new FileOutputStream("info.txt");

        // 将集合中数据存储到文件中,使用store方法
        prop.store(fos,"name + age");

        fos.close();
    }

    private static void propertiesDemo_2() {
        Properties prop = new Properties();

        // 存储元素
        prop.setProperty("zhangsan", "30");
        prop.setProperty("lisi", "20");
        prop.setProperty("wangwu", "33");
        prop.setProperty("liuliu", "10");
        prop.setProperty("wuil", "90");

       // prop = System.getProperties();
        prop.list(System.out);
    }

    public static void propertiesDemo() {
        Properties prop = new Properties();

        // 存储元素
        prop.setProperty("zhangsan", "30");
        prop.setProperty("lisi", "20");
        prop.setProperty("wangwu", "33");
        prop.setProperty("liuliu", "10");
        prop.setProperty("wuil", "90");

        // 取出所有元素
        Set<String> names = prop.stringPropertyNames();
        for (String name :
                names) {
            String value = prop.getProperty(name);
            System.out.println(name + ":" + value);

        }
    }
}
