package top.clearlight.book.coretech.interfaces.test2;

public class Student extends Animal implements People {

    @Override
    public String move(String s) {
        return s;
    }

    @Override
    public boolean isMove(String s) {
        return true;
    }

    // @Override
    // public int Help() {
    //     return 0;
    // }

    // @Override
    // public int Help() {
    //     return 2;
    // }

    // @Override
    // public int Help() {
    //     return 0;
    // }

    public static void main(String[] args) {
        People p = new Student();
        String move = p.move("奔跑");
        System.out.println(move);

        System.out.println(p.isMove("奔跑"));

        System.out.println(p.Help());
    }


}
