package cn.com.clearlight.io.objectstream.demo;

import cn.com.clearlight.setframe.set.bean.Person;

import java.io.*;

public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeObj();
        readObj();
    }

    private static void readObj() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object"));
        Person p = (Person) ois.readObject();
        System.out.println(p.getName() + " : " + p.getAge());
        ois.close();
    }

    private static void writeObj() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.object"));
        // 对象序列化. 被序列化的对象必须实现Serializable接口
        oos.writeObject(new Person(30, "小强"));
        oos.close();
    }


}
