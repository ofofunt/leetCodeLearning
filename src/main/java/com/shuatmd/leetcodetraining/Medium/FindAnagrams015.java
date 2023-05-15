package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//剑指 Offer II 015. 字符串中的所有变位词
//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//变位词 指字母相同，但排列不同的字符串。
public class FindAnagrams015 {
    //手搓解法1：尝试用滑动窗口 具体解法与014类似
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        if(m < n){
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        char[] chars = p.toCharArray();
        char[] charsCur = s.toCharArray();
        for (char c : chars) {
            count1[c - 'a'] += 1;
        }
        for (int i = 0; i < n; i++) {
            count2[charsCur[i] - 'a'] += 1;
        }
        if(Arrays.equals(count1, count2)){
            resultList.add(0);
        }
        for (int i = 0; i < charsCur.length - n; i++) {
            count2[charsCur[i] - 'a'] -= 1;
            count2[charsCur[i + n] - 'a'] += 1;
            if(Arrays.equals(count1, count2)){
                resultList.add(i + 1);
            }
        }
        return resultList;
    }
}
