package com.shuatmd.leetcodetraining.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//面试题 01.04. 回文排列
//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//
//回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
//
//回文串不一定是字典当中的单词。
public class Pliindrome0104 {
    //简化解法：使用set轮询整个数组
    //手搓解法：HashMap存储所有单词的出现次数,判断是否每个单词出现偶数次
    public boolean canPermutePalindromeAdvanced(String s) {
        char[] chars = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        //i记录单次出现的character次数
        int i = 0;
        for (char chara : chars) {
            //如果可以添加 代表是单独出现 i + 1
            if (charSet.add(chara)) {
                i++;
            }
            //无法添加,代表存在偶数次出现
            //从set中remove掉当前character 同时计数器-1
            else {
                charSet.remove(chara);
                i--;
            }
        }
        //允许最多存在1个单次出现的character
        return i <= 1;
    }

    //过于复杂 需要遍历2次
    //用set可以解约时间
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> wordCount = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            wordCount.put(chars[i], wordCount.getOrDefault(chars[i], 0) + 1);
        }
        int single = 0;
        if (chars.length % 2 > 0) {
            single = 1;
        }
        int singleCount = 0;
        for (int i : wordCount.values()) {
            if (i % 2 != 0) {
                singleCount++;
            }
        }
        return singleCount <= single;
    }
}
