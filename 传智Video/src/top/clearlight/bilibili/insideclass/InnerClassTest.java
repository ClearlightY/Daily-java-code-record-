package top.clearlight.bilibili.insideclass;

public class InnerClassTest {
    private String name = "外部类的属性";

    public void testDemo() {
        System.out.println("这是外部类中的方法");

        // 定义一个局部内部类
        class LocalClass {
            private String name;
            public void test() {
                System.out.println(name);
            }
        }
    }

    // 成员内部类
    public class InnerDemo {
        private String name = "内部类的属性";

        public void testDemo() {
            int a;
            // 通过外部类.this.属性名来调用同名的域,否则直接name则为就近原则
            System.out.println("这是内部类中的方法" + InnerClassTest.this.name);
        }
    }

    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();

        System.out.println(innerClassTest.name);
        innerClassTest.testDemo();

        InnerDemo id = innerClassTest.new InnerDemo();

        System.out.println(id.name);
        id.testDemo();

        innerClassTest.testDemo();
    }
}
