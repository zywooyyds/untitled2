package com.sy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import static com.sy.constant.Constant.SESSION_VALIDATE_CODE_NAME;
import static com.sy.util.RandomUtils.getRandomColor;
import static com.sy.util.RandomUtils.getRandomValidateCode;

@RestController
@RequestMapping("validateCode")
public class ValidateCodeController extends HttpServlet {
    private static final int WIDTH = 120;
    private static final int HEIGHT = 40;
    private static final int START_POSITION_X = 0;
    private static final int START_POSITION_Y = 0;
    private static final int CODE_LENGTH = 4;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.准备一个基于内存的画板对象，在画板中将图片进行绘制
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //2.获取画笔对象
        Graphics g = image.getGraphics();
        //3.绘制背景色
        //设置画笔颜色
        g.setColor(getRandomColor());
        g.fillRect(START_POSITION_X, START_POSITION_Y, WIDTH, HEIGHT);
        //4.绘制随机字符串
        String validateCode = getRandomValidateCode(CODE_LENGTH);
        //将验证码写入Session方便后续验证
        req.getSession().setAttribute(SESSION_VALIDATE_CODE_NAME, validateCode);
        System.out.println(validateCode);
        //设置画笔颜色
        g.setColor(getRandomColor());
        g.setFont(new Font("", Font.BOLD, 20));
        g.drawString(validateCode, 30, 20);
        //5.绘制噪音线
        Random r = new Random();
        for (int i = 1; i <= 20; i++) {
            g.setColor(getRandomColor());
            g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(WIDTH), r.nextInt(HEIGHT));
        }

        //将内存中的图片输出到客户端中
        try {
            //设置消息类型为image/png
            resp.setContentType("image/png");
            ImageIO.write(image, "png", resp.getOutputStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
