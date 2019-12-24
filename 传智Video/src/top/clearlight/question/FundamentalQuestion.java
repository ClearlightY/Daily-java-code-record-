package top.clearlight.question;

import org.junit.jupiter.api.Test;

public class FundamentalQuestion {
    public static void main(String[] args) {
        int i = 0;
        for (int j = 0; j < 50; j++) {
            i = i++;
        }
        System.out.println(i);

        // partVar().a;
    }

    public static void partVar() {
        int a = 1;
    }

    @Test
    public void test() {
        System.out.println(S.abc);
    }

}


class P {
    public static int abc = 123;

    static {
        System.out.println("P is init");
    }
}

class S extends P {
    static {
        System.out.println("S is init");
    }
}

