package com.shuatmd.leetcodetraining.Easy;

public class ReverseWordsLeftwards58 {
    //正常解法1：需要用的substring 可能面试不让用
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n));
        sb.append(s.substring(0, n));
        return sb.toString();
    }

    //简单解法1：运用求余方法来简单实现
    public String reverseLeftWordsMath(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            //从第n位开始,超过n位的因为取余数变成正常位数
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }
}
