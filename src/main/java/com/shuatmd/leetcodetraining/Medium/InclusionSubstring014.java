package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//剑指 Offer II 014. 字符串中的变位词
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
//换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
public class InclusionSubstring014 {
    //手搓解法1: 滑动窗口
    //使用一个长度大小等于目标string大小的滑动窗口,轮询判断是否相等
    //可以优化的点, 每次循环其实只是弹出一个字母+添加另外一个字母
    //与其比较2个数组 可以直接比较2个数组的差值
    public boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        //先判断一次string长度,如果s2比s1还短,则不可能实现包含
        int m = s2.length();
        if(length > m){
            return false;
        }
        //新建2个数组,数组1记录目标字符串(S1)中的所有字母的个数
        //数组2记录当前滑动窗口中所有单词的字数
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        char[] chars = s1.toCharArray();
        //算出目标string的所有字母的出现次数
        for (char c : chars) {
            count1[c - 'a'] += 1;
        }
        char[] charCur = s2.toCharArray();
        //初始化第一次滑动窗口的字母个数
        for (int i = 0; i < length; i++) {
            count2[charCur[i] - 'a'] += 1;
        }
        if(Arrays.equals(count1,count2)){
            return true;
        }
        //从index = 0开始,遍历所以长度为length的子串,同时对比是否字母出现次数相等
        for (int i = 0; i < charCur.length - length ; i++) {
            //窗口往前移动一格,弹出当前最左边的字母
            count2[charCur[i] - 'a'] -= 1;
            //添加当前位数 + length位置的元素到当前的字母表里面
            count2[charCur[i + length] - 'a'] += 1;
            if(Arrays.equals(count1,count2)){
                return true;
            }
        }
        return false;
    }

    //改进版本滑动窗口
    //简化了对比的过程 将count1[] 与 count2[] 对比的过程简化为 cnt = count1[x] - count2[x]
    //转化成了cnt[x] 与 0的对比
    public boolean checkInclusionAdvanced(String s1, String s2) {
        int n = s1.length();
        //先判断一次string长度,如果s2比s1还短,则不可能实现包含
        int m = s2.length();
        if(n > m){
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                ++diff;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                ++diff;
            }
            ++cnt[x];
            if (cnt[x] == 0) {
                --diff;
            }
            if (cnt[y] == 0) {
                ++diff;
            }
            --cnt[y];
            if (cnt[y] == 0) {
                --diff;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }


}
