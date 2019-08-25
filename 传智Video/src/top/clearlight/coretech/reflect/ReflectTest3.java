package top.clearlight.coretech.reflect;

class Window {

    static {
        System.out.println("Window static");
    }

    Window (int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

class House {

    static {
        System.out.println("House static");
    }

    Window w1 = new Window(1);// Before constructor
    House () {
        System.out.println("House()");
        w3 = new Window(33);
    }

    Window w2 = new Window(2);
    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3);
}

public class ReflectTest3 {
    public static void main(String[] args) {
        House h = new House();
        h.f();
    }
}
