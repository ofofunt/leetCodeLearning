package com.shuatmd.leetcodetraining.Easy;

//剑指 Offer II 002. 二进制加法
//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
//
//输入为 非空 字符串且只包含数字 1 和 0。
public class BinaryAdd002 {
    //解法1：转成整形数字,相加再转回为二进制数字
    //缺陷：位数超过33位,无法转换为Interger,超过65为无法转换为Long
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    //解法2：模拟法
    //模拟整个运算的过程
    public String addBinaryMock(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0;

        //获得a,b的最大长度
        int length = Math.max(a.length(), b.length());
        for (int i = 0; i < length; i++) {
            //分别获取a,b当前位数的值 并且相加
            carry += i < a.length() ? (a.charAt(a.length() - i - 1) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - i - 1) - '0') : 0;
            sb.append((char) (carry % 2 + '0'));
            //判断进位
            carry /= 2;
        }
        if (carry > 0) {
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();

    }
}
