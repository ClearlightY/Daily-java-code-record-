package top.clearlight.question;

import java.util.Scanner;
class CFX{                         //长方形类
    double length;                   //长方形的长
    double width;                   //长方形的宽

    public void Set() {             //设置长宽
        Scanner in=new Scanner(System.in);
        System.out.println("输入长方形的长：");
        length=in.nextDouble();
        System.out.println("输入长方形的宽：");
        width=in.nextDouble();
    }
    public void Get() {				//获得长宽
        System.out.println("长方形的长为："+length);
        System.out.println("长方形的宽为："+width);
        System.out.println("长方形的周长为："+(2*(length+width)));
        System.out.println("长方形的面积为："+(length*width));
    }
}
public class jieguo {
    public static void main(String[] args) {
        CFX c=new CFX();
        c.Set();
        c.Get();
    }

}
