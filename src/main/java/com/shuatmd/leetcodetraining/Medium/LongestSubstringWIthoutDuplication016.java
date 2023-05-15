package com.shuatmd.leetcodetraining.Medium;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//剑指 Offer II 016. 不含重复字符的最长子字符串
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
public class LongestSubstringWIthoutDuplication016 {
    //解法4：最终优化版本
    public int lengthOfLongestSubstring4(String s) {
        int maxLength = 0;
        int l = 0;
        int length = s.length();
        int[] indexArray = new int[128];
        for (int i = 0; i < length; i++) {
            char cur = s.charAt(i);
            //查询当前字母是否重复
            int index = indexArray[cur];
            //根据重复情况重新给左边index赋值
            l = Math.max(l, index);
            indexArray[cur] = i + 1;
            maxLength = Math.max(maxLength, i - l + 1);
        }
        return maxLength;
    }

    //解法3: 不用循环判断左边的index
    //可以优化的点: 因为只有26个字母 可以考虑只用array来存index
    public int lengthOfLongestSubstring3(String s) {
        int maxLength = 0;
        int l = 0;
        int length = s.length();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < length; i++) {
            char cur = s.charAt(i);
            //查询当前字母是否重复
            int index = map.getOrDefault(cur,0);
            //根据重复情况重新给左边index赋值
            l = Math.max(l, index);
            map.put(cur, i + 1);
            maxLength = Math.max(maxLength, i - l + 1);
        }
        return maxLength;
    }
    //手搓解法2： 滑动窗口 + contains
    //滑动窗口s[i][j] 判断s[j]是否在substring(i,j)之中
    //如果存在相同的字母,则循环弹出左边框的字母直到弹出重复的单词
    //可以优化的点：可以换成使用map来记录重复词出现的index,
    public int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        int l = 0;
        int length = s.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char cur = s.charAt(i);
            while(set.contains(cur)){
                set.remove(s.charAt(l));
                l ++;
            }
            maxLength = Math.max(maxLength, i - l + 1);
            set.add(cur);
        }
        return maxLength;
    }
    //手搓解法1： 用map来判断是否重复 轮询整个string 之后求出最长的长度
    //优化: map查询时间太长
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        //用map来记录单词出现的次数
        Map<Character, Integer> map = new LinkedHashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            //将当前字母放入到map之中并且出现次数+1
            map.put(cur,map.getOrDefault(cur,0) + 1);
            //判断如果这个字母已经出现过2次以及2次以上,则说明出现重复
            if(map.getOrDefault(cur, 0) >= 2){
                //判断这个字母最后出现的位置 重新地位他的下一个角标为新的左标
                j = s.substring(j,i).lastIndexOf(cur) + 1 + j;
                map.put(cur,map.get(cur) - 1);
            }
            length = Math.max(length, i - j + 1);
        }
        return length;
    }
}
