package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//面试题 01.01. 判定字符是否唯一
//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
public class isUniqueChar0101 {
    //不用额外的数据结构做法： 使用int[]
    public boolean isUniqueArray(String astr) {
        int[] wordCount = new int[26];
        Arrays.fill(wordCount,0);
        for (char c : astr.toCharArray()) {
            if(wordCount[c - 'a'] > 0){
                return false;
            }
            wordCount[c - 'a'] += 1;
        }
        return true;
    }
    //手搓解法,丢进一个HashMap里面再判断
    public boolean isUnique(String astr) {
        Map<Character,Integer> wordMap = new HashMap<>();
        for (char c : astr.toCharArray()) {
            if(wordMap.get(c) != null && wordMap.get(c) >0){
                return false;
            }
            wordMap.put(c,1);
        }

        return true;
    }
}
