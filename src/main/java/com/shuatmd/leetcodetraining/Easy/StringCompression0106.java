package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//面试题 01.06. 字符串压缩
//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/compress-string-lcci
public class StringCompression0106 {

    public String compressStringAdvanced(String S) {
        if(S.length() < 1){
            return S;
        }
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        //设置初始count为1,将char第一位放入Set中初始化
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            //如果可以插入则说明当前不存在连续字母的情况
            //将之前的character和总共连续的次数count返回
            if(chars[i] != chars[i - count]){
                sb.append(chars[i - count]);
                sb.append(count);
                count = 1;
            }
            //如果无法插入,则说明还是在连续出现,count++
            else{
                count ++;
            }
        }
        //最后出现的字符无法判断次数,手动判断
        sb.append(chars[chars.length -1]);
        sb.append(count);
        return sb.toString().length() >= S.length()? S: sb.toString();
    }
    //手搓解法1：遍历的同时拼凑整个StringBuilder
    //最后对比StringBuilder.toString和当前字符串S的长度
    public String compressString(String S) {
        if(S.length() < 1){
            return S;
        }
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<Character> wordSet = new HashSet<>();
        //设置初始count为1,将char第一位放入Set中初始化
        int count = 1;
        wordSet.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            //如果可以插入则说明当前不存在连续字母的情况
            //将之前的character和总共连续的次数count返回
            if(wordSet.add(chars[i])){
                sb.append(chars[i - count]);
                sb.append(count);
                count = 1;
                wordSet.remove(chars[i - count]);
            }
            //如果无法插入,则说明还是在连续出现,count++
            else{
                count ++;
            }
        }
        //最后出现的字符无法判断次数,手动判断
        sb.append(chars[chars.length -1]);
        sb.append(count);
        return sb.toString().length() >= S.length()? S: sb.toString();
    }

    public static void main(String[] args) {
        StringCompression0106 stringCompression0106 = new StringCompression0106();
        stringCompression0106.compressString("aabcccccaa");
    }
}
