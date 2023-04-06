package com.shuatmd.leetcodetraining.Easy;

//剑指 Offer 58 - I. 翻转单词顺序
//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
//为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
public class ReverseWrods58 {
    //解法1：通过trim()以及正则来避免出现空格
    public String reverseWords(String s) {
        String[] s1 = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            sb.append(s1[i] + " ");
        }
        return sb.toString().trim();
    }

    //解法2：面试写法,用双指针来做而不是用spilt
    public String reverseWordsOfficial(String s) {
        //用trim去除空格
        String trim = s.trim();
        int i = trim.length() -1;
        int j = i;
        StringBuilder sb = new StringBuilder();
        while(i >= 0){
            //持续右移指针 直到找到第一个空格 此时substring(i + 1, j + 1)为独立单词
            while(i >= 0 && trim.charAt(i) != ' '){
                i --;
            }
            sb.append(trim.substring(i+1, j+1) + " ");
            //如果存在连续空格,需要一起删除
            while(i>=0 && trim.charAt(i) == ' '){
                i --;
                j = i;
            }
        }
        return sb.toString().trim();
    }
}
