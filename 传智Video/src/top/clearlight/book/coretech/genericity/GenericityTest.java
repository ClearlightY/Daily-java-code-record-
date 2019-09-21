package top.clearlight.book.coretech.genericity;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GenericityTest {

    @Test
    public void test1() {
        Map<String, Integer> m = new HashMap<>();
        m.put("Jack", 19);
        m.put("Mary", 17);
        m.put("Bob", 21);

        Set<Map.Entry<String, Integer>> entries = m.entrySet();
        
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> me = iterator.next();
            System.out.println(me.getKey() + " " + me.getValue());
        }

        for (Map.Entry<String, Integer> me : entries) {
            System.out.println(me.getKey() + " " + me.getValue());
        }


    }
}
