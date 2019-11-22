package top.clearlight;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码框架 kaptcha
 * <p>
 * 对验证码实现后, 并且将生成的验证码存储到session中
 */
@WebServlet("/identifyCodeServlet")
public class IdentifyCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        // 1. 创建对象, 在内存中图片(验证码图片对象)
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 2. 美化图片
        // 2.1 填充背景色
        // 画笔对象
        Graphics g = image.getGraphics();
        // 设置画笔颜色
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width, height);

        // 2.2 画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        // 2.3 写验证码
        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz1234567890";
        // 生成随机角标
        Random r = new Random();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = r.nextInt(str.length());
            // 随机字符
            char ch = str.charAt(index);
            sb.append(ch);
            // 写验证码
            g.drawString(ch + "", width / 5 * i - 10, height / 2);
        }

        String checkCode_session = sb.toString();
        // 将验证码存储到session中
        request.getSession().setAttribute("checkCode_session", checkCode_session);

        // 2.4 画干扰线
        g.setColor(Color.GREEN);

        // 随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = r.nextInt(width);
            int x2 = r.nextInt(width);

            int y1 = r.nextInt(height);
            int y2 = r.nextInt(height);

            g.drawLine(x1, y1, x2, y2);
        }

        // 3. 将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
