package com.sy.util;

import java.awt.*;
import java.util.Random;

public class RandomUtils {
    private RandomUtils() {

    }

    /**
     * 用于生成动态的验证码
     * @param length 验证码的长度
     * @return 生成的随机验证码
     */
    public static String getRandomValidateCode(int length) {
        Random r = new Random();
        String str = "3456789abcdefghijkmnpqrstuvwxy";
        String result = "";
        for (int i = 1; i <= length; i++) {
            result += str.charAt(r.nextInt(str.length()));
        }
        return result;
    }

    /**
     * 获取随机的颜色
     * @return
     */
    public static Color getRandomColor() {
        Random r = new Random();
        return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }

}
