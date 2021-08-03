package cn.com.clearlight.basics.grammar;

/*
  如果变量是基本数据类型，此时赋值的是变量所保存的数据值
  如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值
 */
public class ValueTransferTest {
    public static void main(String[] args) {
        String s1 = "Hello";
        ValueTransferTest valueTransferTest = new ValueTransferTest();
        String temp = valueTransferTest.changeValue(s1);
        System.out.println(temp);
        System.out.println(s1);
    }

    public String changeValue(String s) {
        s = "Hi";
        return s;
    }
}
