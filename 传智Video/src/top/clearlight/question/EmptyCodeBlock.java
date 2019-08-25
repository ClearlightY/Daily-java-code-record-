package top.clearlight.question;

public class EmptyCodeBlock {
    private static int uid = 10;
    private int id = 1;

    // 空代码块
    {
        System.out.println(id);
        System.out.println("空代码块,在构造方法之前");
    }

    public EmptyCodeBlock() {
        id = 2;
        System.out.println("无参构造函数");
    }

    public EmptyCodeBlock(int uid) {
        this.uid = uid;
    }

    // 静态代码块
    static {
        System.out.println("静态代码块前");
    }

    {
        System.out.println(id);
        System.out.println("空代码块,在构造方法之后");
    }

    static {
        System.out.println("静态代码块后");
    }

    public static void main(String[] args) {
        EmptyCodeBlock ecb = new EmptyCodeBlock();
        System.out.println(ecb.id);

        System.out.println(EmptyCodeBlock.uid);
        EmptyCodeBlock ecb2 = new EmptyCodeBlock(20);
        System.out.println(ecb2.id);
        System.out.println(EmptyCodeBlock.uid);
    }
}