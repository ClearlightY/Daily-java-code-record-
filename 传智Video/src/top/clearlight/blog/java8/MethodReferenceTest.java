package top.clearlight.blog.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * 参考博客:https://blog.csdn.net/wonking666/article/details/79208863

 * @Date 2019.9.24
 */
public class MethodReferenceTest {
    public static void main(String[] args) {
        List<String> strings= Arrays.asList("hehe","","wonking","memeda");
        List<Integer> lengths=map(strings, (String s)->s.length());
        System.out.println(lengths);
        // lengths.sort((i1,i2)-> i1.compareTo(i2));
        // lengths.sort(new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         return o1.compareTo(o2);
        //     }
        // });

        // lengths.sort(((o1, o2) -> o1.compareTo(o2)));
        lengths.sort(comparing(Integer::intValue));
        // lengths.sort((Integer::compareTo));


        System.out.println(lengths);
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result=new ArrayList<R>(list.size());
        for(T t:list){
            result.add(f.apply(t));
        }
        return result;
    }

    public static List<Integer> filterOdd(List<Integer> list, Predicate<Integer> p){
        List<Integer> result=new ArrayList<>();
        for(Integer i: list){
            if(p.test(i)){
                result.add(i);
            }
        }
        return result;
    }

}
