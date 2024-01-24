package com.shuatmd.leetcodetraining.Medium;
//面试题 16.02. 单词频率
//设计一个方法，找出任意指定单词在一本书中的出现频率。
//
//你的实现应该支持如下操作：
//
//WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
//get(word)查询指定单词在书中出现的频率
//https://leetcode.cn/problems/words-frequency-lcci/

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency1602 {
    Map<String, Integer> countMap;

    public WordsFrequency1602(String[] book) {
        countMap = new HashMap<>();
        for (String word : book) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
    }

    public int get(String word) {
        return countMap.getOrDefault(word, 0);
    }
}
