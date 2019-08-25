package top.clearlight.wechat.Thread;

public class AnimalTest {
    public static void main(String[] args) {
        Thread rabbit = new Thread(new Animal("兔子"));
        Thread tortoise = new Thread(new Animal("乌龟"));

        rabbit.start();
        tortoise.start();
    }
}
