package top.clearlight.coretech.interfaces.test2;

public interface People {

    String move(String s);

    default boolean isMove(String s) {
        return s.equals("行走");
    }

    // int Help();

    default int Help() {
        return 3;
    }

    // int Help();

}
