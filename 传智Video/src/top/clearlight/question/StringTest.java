package top.clearlight.question;

public class StringTest {
    public static void main(String[] args) {
        String s = "a" + "b";
        String s1 = "ab";
        System.out.println(s == s1);
        System.out.println(s.equals(s1));

        String s2 = "ab" + "cd";
        String s3 = "abc" + "d";

    }
}
