package top.clearlight.question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class TriangleUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();// 框
        frame.setSize(380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();// 板

        GridLayout layout = new GridLayout(8, 2);// 布局(9行3列)

        panel.setLayout(layout);// 将panel按照指定布局走

        frame.add(panel);// 把板钉到框上

        // 准备"件"
        JLabel titile = new JLabel("三角形问题");
        panel.add(new JLabel());//
        panel.add(titile);
        panel.add(new JLabel());

        // 第二行
        JLabel ageLabel = new JLabel("边长A:");
        panel.add(ageLabel);
        final JTextField ageText = new JTextField();
        panel.add(ageText);
        panel.add(new JLabel("cm"));

        // 第三行
        JLabel genderLabel = new JLabel("边长B:");
        panel.add(genderLabel);
        final JTextField genderText = new JTextField();
        panel.add(genderText);
        panel.add(new JLabel("cm"));

        // 第四行
        JLabel tallLabel = new JLabel("边长C:");
        panel.add(tallLabel);
        final JTextField tallText = new JTextField();
        panel.add(tallText);
        panel.add(new JLabel("cm"));


        //第五行
        JLabel judgeLabel = new JLabel("判定方法:");
        panel.add(judgeLabel);
        final JComboBox judgeBox = new JComboBox();// 下拉选框
        judgeBox.addItem("边关系判定");
        judgeBox.addItem("角关系判定");
        judgeBox.addItem("边和角关系");
        panel.add(judgeBox);
        panel.add(new JLabel(""));


        // 第八行
        panel.add(new JLabel());
        JButton btn = new JButton("计算");
        panel.add(btn);
        panel.add(new JLabel(""));//

        // 第九行
        panel.add(new JLabel());
        final JLabel result = new JLabel("结果");
        panel.add(result);
        panel.add(new JLabel(""));

        frame.setVisible(true);// 显示这个窗口

        // ActionListener是一个接口,new的并不是接口,而是接口的实现类
        // 这种写法叫创建 匿名内部类对象
        ActionListener listener = new ActionListener() {
            // 点击按钮的时候,会自动触发这个方法
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取面板上身高,年龄,性别,体重,心态,吸烟与否的值
                String A = tallText.getText();
                String B = ageText.getText();
                String C = genderText.getText();
                //String weightString = weightText.getText();
                String judgeString = (String) judgeBox.getSelectedItem();
                //String smokeString = (String) smokeBox.getSelectedItem();
                // System.out.println(tallString);

                Float a = Float.parseFloat(A);
                Float b = Float.parseFloat(B);
                Float c = Float.parseFloat(C);
                if (a + b <= c || a + c <= b || b + c <= a) {
                    System.out.println("您输入的三边不能构成三角形,请重新输入");
                    result.setText("您输入的三边不能构成三角形,请重新输入");
                    return;
                }

                Float[] m = new Float[3];
                m[0] = a; m[1] = b; m[2] = c;
                Arrays.sort(m);

                if("边关系判定".equals(judgeString)) {
                    EdgeRelation edge = new EdgeRelation();
                    result.setText(edge.Edge(m[0], m[1], m[2]));
                    return;

                } else if("角关系判定".equals(judgeString)) {
                    AngularRelation angular = new AngularRelation();
                    result.setText(angular.Angular(m[0], m[1], m[2]));
                    return;
                } else {
                    EdgeAngularRelation edgeAngular = new EdgeAngularRelation();
                    result.setText(edgeAngular.EdgeAngular(m[0], m[1], m[2]));
                    return;
                }

            }
        };
        btn.addActionListener(listener);// 给按钮添加单击事件
    }
}

class AngularRelation {
    public String Angular(float a, float b, float c) {
        float x, y;
        x = a * a + b * b;
        y = c * c;
        if (x > y) {
            return "这个三角形是锐角三角形";
        } else if (x < y) {
            return "这个三角形是钝角三角形";
        } else {
            return "这个三角形是直角三角形";
        }
    }
}

class EdgeAngularRelation {
    public String EdgeAngular(float a, float b, float c) {
        float cosC;
        cosC = (a * a + b * b - c * c) / 2 * a * b;
        if (cosC > 0) {
            return "该三角形为锐角三角形";
        } else if (cosC < 0) {
            return "该三角形为钝角三角形";
        } else {
            return "该三角形为直角三角形";
        }
    }
}

class EdgeRelation {
    public String Edge(float a, float b, float c) {
        if (a == b || a == c || b == c) {
            if (a == b && a == c && b == c) {
                return "该三角形为等边三角形";
            } else {
                if (a * a + b * b == c * c) {
                    return "该三角形为等腰直角三角形";
                } else {
                    return "该三角形为等腰三角形";
                }
            }
        } else {
            if (a * a + b * b == c * c) {
                return "该三角形为直角三角形";
            } else {
                return "该三角形为一般三角形";
            }
        }
    }
}
