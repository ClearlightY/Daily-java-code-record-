package top.clearlight.coretech.interfaces;

public class InterfaceTest {
    public static void main(String[] args) {
        Volant volant = new Angel();
        volant.fly();
        System.out.println(Volant.FLY_HEIGHT);

        Honest honest = new GoodMan();
        honest.helpOther();

        Volant volant1 = new BirdMan();
        volant.fly();
        System.out.println(volant1.FLY_HEIGHT);
    }
}

interface Volant {
    int FLY_HEIGHT = 100; // 总是：public static final类型
    void fly();
}

interface Honest {
    void helpOther();
}

class Angel implements Volant, Honest {

    @Override
    public void fly() {
        System.out.println("I'm angel");
    }

    @Override
    public void helpOther() {
        System.out.println("Help other");
    }
}

class GoodMan implements Honest {

    @Override
    public void helpOther() {
        System.out.println("I'm hero to help other");
    }
}

class BirdMan implements Volant {

    @Override
    public void fly() {
        System.out.println("I can fly to help other");
    }
}