package top.clearlight.blog.sugar;

public class StringSwitchSuger {
    public static void main(String[] args) {
        String str = "yellow";

        switch (str) {
            case "red":
                System.out.println("The color is red");
                break;
            case "yellow":
                System.out.println("The color is yellow");
                break;
            case "black":
                System.out.println("The color is black");
                break;
            default:
                System.out.println("Input error");
                break;
        }

               char ch = 'a';

        switch (ch) {
            case 'a':
                System.out.println("a");
                break;
            default:
                System.out.println("默认");
                break;
        }

        getStrHash();
    }

    private static void getStrHash() {
        System.out.println("yellow".hashCode());
        System.out.println("red".hashCode());
        System.out.println("black".hashCode());
    }
}
