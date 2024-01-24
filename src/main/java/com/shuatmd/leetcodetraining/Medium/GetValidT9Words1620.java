package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//面试题 16.20. T9键盘
//在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：
//https://leetcode.cn/problems/t9-lcci/
public class GetValidT9Words1620 {
    //手搓尝试: 双遍历判断 + hash
    //存在更简单的写法 而且每次遍历都判断contains过于浪费,可以直接用一个int[26]来存26位字母锁对应的键盘上数字 再进行比对 不需要循环contains
    public List<String> getValidT9Words(String num, String[] words) {
        Map<Character,String> dict = new HashMap<>();
        dict.put('2',"abc");
        dict.put('3',"def");
        dict.put('4',"ghi");
        dict.put('5',"jkl");
        dict.put('6',"mno");
        dict.put('7',"pqrs");
        dict.put('8',"tuv");
        dict.put('9',"wxyz");
        List<String>resList = new ArrayList<>();
        char[] nums = num.toCharArray();
        boolean correct = false;
        for (String word : words) {
            correct = true;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(dict.get(nums[i]).indexOf(chars[i]) < 0){
                    correct = false;
                    break;
                }
            }
            if(correct){
                resList.add(word);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        GetValidT9Words1620 getValidT9Words = new GetValidT9Words1620();
        getValidT9Words.getValidT9Words("8733",new String[]{"tree","used"});
    }
}
