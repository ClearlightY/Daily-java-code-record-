package cn.com.clearlight.io.properties.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        getAppCount();
    }

    private static void getAppCount() throws IOException {
        // 将配置文件封装成File对象.
        File confile = new File("count.properties");

        if (!confile.exists()) {
            confile.createNewFile();
        }

        FileInputStream fis = new FileInputStream(confile);

        Properties prop = new Properties();

        prop.load(fis);

        // 从集合中通过键获取次数
        String value = prop.getProperty("time");

        // 定义计数器.记录获取到的次数.
        int count = 0;
        if (value != null) {
            count = Integer.parseInt(value);
            if (count >= 5) {
               // System.out.println("使用次数已结束,请您输入注册码!");
                throw new RuntimeException("使用次数已结束,请您输入注册码!");
            }
        }
        count++;

        // 将改变后的次数重新存储到集合中.
        prop.setProperty("time", count + "");

        FileOutputStream fos = new FileOutputStream(confile);

        prop.store(fos, "");

        fos.close();
        fis.close();
    }
}
