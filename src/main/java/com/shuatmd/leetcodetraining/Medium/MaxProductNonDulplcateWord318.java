package com.shuatmd.leetcodetraining.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//318. 最大单词长度乘积
//给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
//https://leetcode.cn/problems/maximum-product-of-word-lengths/description/
//
public class MaxProductNonDulplcateWord318 {
    /*官方解法1：位计算+掩码
    如果通过暴力的方法来判断两个string间是否存在重复需要大于o(n^2)的时间 耗时太长
    通过掩码+位运算可以将判断是否存在重复单词的耗时降低为O(1)
     */
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] mask = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                //用一个26位二进制的数来记录每个字母的出现情况
                //比如如果abc 则转换为 0 ... 0 1 1 1
                //如果dca  则为 0... 1 1 0 1
                mask[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                //如果(mask[i] & mask[j]) == 0 则说明不存在重复的单词
                if((mask[i] & mask[j]) == 0){
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

    //官方解法2: 在解法1的情况下做优化
    //在解法1中,遍历出所有单词的26位掩码之后并没有进行筛选
    //解法2优化的部分就是做一个筛选,比如meet与met 掩码是相同的, 可以剔除掉met,只保留meet
    //减少一部分遍历时候的重复选项
    public int maxProductAdvanced(String[] words) {
        int length = words.length;
        int[] mask = new int[length];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                mask[i] |= 1 << (word.charAt(j) - 'a');
            }
            if(wordLength > map.getOrDefault(mask[i], 0)){
                map.put(mask[i],word.length());
            }
        }
        int result = 0;
        Set<Integer> markSet= map.keySet();
        for (Integer word1 : markSet) {
            for (Integer word2 : markSet) {
                if((word1 & word2) == 0){
                    result = Math.max(result, map.get(word1) * map.get(word2));
                }
            }
        }
        return result;
    }
}
