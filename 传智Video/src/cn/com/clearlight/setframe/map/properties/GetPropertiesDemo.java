package cn.com.clearlight.setframe.map.properties;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * 打印系统信息的方法
 */
public class GetPropertiesDemo {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<String> ps = properties.stringPropertyNames();
        Iterator<String> iterator = ps.iterator();
        for (Iterator<String> it = iterator; it.hasNext(); ) {
            String s = it.next();
            System.out.println(s + ":" + properties.getProperty(s));
        }
    }
}
