package top.clearlight.question;

public class Test3 {
    public static void main(String[] args) {
        boolean and = and(true);
    }

    private static boolean and(boolean booleans) {
        System.out.println("boolean");
        /*for (boolean b :
                booleans) {
            if (!b) {
                return false;
            }
        }*/
        return true;
    }

    private static boolean and(Boolean  booleans) {
        System.out.println("Boolean");
        /*for (Boolean b :
                booleans) {
            if (!b) {
                return false;
            }
        }*/
        return true;
    }
}
