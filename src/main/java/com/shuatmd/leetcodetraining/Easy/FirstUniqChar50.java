package com.shuatmd.leetcodetraining.Easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//剑指 Offer 50. 第一个只出现一次的字符
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
public class FirstUniqChar50 {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character,Boolean> resultMap = new LinkedHashMap<>();
        for (char aChar : chars) {
            resultMap.put(aChar,resultMap.containsKey(aChar));
        }
        for (char aChar : chars) {
            if(!resultMap.get(aChar)){
                return aChar;
            }
        }
        return ' ';
    }
}
