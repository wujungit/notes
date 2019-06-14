package com.kanghe.notes.util;

import java.util.Random;

/**
 * @author mask
 * @date 2018-6-5
 */
public class CodeUtil {
    /**
     * 生成固定长度的随机数字
     *
     * @param length
     * @return
     */
    public static String randomNumber(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 生成带前缀的随机编码
     *
     * @param prefix
     * @param bit    数字长度
     * @return
     */
    public static String prefixRandom(String prefix, int bit) {
        String timeStr = System.currentTimeMillis() + "";
        int num = bit - timeStr.length();
        if (num <= 0) {
            num = 0;
        }
        return prefix + timeStr + randomNumber(num);
    }
}