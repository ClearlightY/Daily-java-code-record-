package top.clearlight.book.coretech.reflect;

import java.util.ArrayList;

/**
 * This program uses reflection to spy on objects
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }


}
