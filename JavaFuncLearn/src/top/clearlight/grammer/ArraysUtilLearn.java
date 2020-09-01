package top.clearlight.grammer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArraysUtilLearn {
    public static void main(String[] args) {
        // *************排序 sort****************
        int a[] = {1, 3, 2, 7, 6, 5, 4, 9};
        // sort(int[] a)方法按照数字顺序排列指定的数组。
        Arrays.sort(a);
        System.out.println("Arrays.sort(a):");
        for (int i : a) {
            System.out.print(i);
        }
        // 换行
        System.out.println();

        // sort(int[] a,int fromIndex,int toIndex)按升序排列数组的指定范围
        int b[] = {1, 3, 2, 7, 6, 5, 4, 9};
        // 第二个索引开始, 到第二个结束
        Arrays.sort(b, 2, 6);
        System.out.println("Arrays.sort(b, 2, 6):");
        for (int i : b) {
            System.out.print(i);
        }
        // 换行
        System.out.println();

        // *************比较 equals****************
        char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        char[] f = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        /*
         * 元素数量相同，并且相同位置的元素相同。 另外，如果两个数组引用都是null，则它们被认为是相等的 。
         */
        // 输出true
        System.out.println("Arrays.equals(e, f):" + Arrays.equals(e, f));

        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
        System.out.println(stooges);

        Object[] objects = stooges.toArray();
        System.out.println(objects);

        List<Object> objects1 = Arrays.asList(objects);
        System.out.println(objects1);

        int[] arr;
        arr = new int[1];
        arr[0] = 1;
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = {1, 2, 3};

    }
}
