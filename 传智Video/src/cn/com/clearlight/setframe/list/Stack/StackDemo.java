package cn.com.clearlight.setframe.list.Stack;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("d");
        stack.pop(); // 弹栈顶元素"d"
        stack.push("c");

        for (String str : stack) {
            System.out.println(str);
        }
        System.out.println(stack.peek()); // 返回栈顶元素不弹出!
        System.out.println(stack.empty()); // 判断栈是否为空
        System.out.println(stack.search("b")); // 查找元素b在栈中的位置
        System.out.println(stack.search("m")); // 栈中不存在的元素返回-1
    }
}
