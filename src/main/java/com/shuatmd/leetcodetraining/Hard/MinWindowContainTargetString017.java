package com.shuatmd.leetcodetraining.Hard;
//剑指 Offer II 017. 含有所有字符的最短字符串
//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
//
//如果 s 中存在多个符合条件的子字符串，返回任意一个。
//
//注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。

import java.util.ArrayList;
import java.util.List;

public class MinWindowContainTargetString017 {
    //滑动窗口解法1：右移r直到当前窗口string中包含t
    //之后不断右移l直到当前窗口string中不包含t
    //继续右移r重复上述操作
    //可以优化的点： 1.左右移的策略 2.高效对比是否包含
    public String minWindow(String s, String t) {
        String res = "";
        int length = s.length();
        if(length < t.length()){
            return "";
        }
        int l = 0;
        int r = 0;
        int[] count = new int[60];
        int[] targetCount = new int[60];
        for (char c : t.toCharArray()) {
            targetCount[c - 'A'] += 1;
        }
        while(r < length){
            Boolean contains = false;
            while(!checkIfContainsTarget(targetCount, count) && r < length){
            count[s.charAt(r) - 'A'] += 1;
            r ++;
            }
            while (checkIfContainsTarget(targetCount, count) && l < length){
                contains = true;
                count[s.charAt(l) - 'A'] -= 1;
                l++;
            }
            if(contains && (r - l < res.length() || res.equals(""))) {
                res = (s.substring(l - 1, r));
            }
        }
        return res;
    }

    private boolean checkIfContainsTarget(int[] targetCount, int[] count) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < targetCount.length; i++) {
            if(targetCount[i] > 0){
                res.add(targetCount[i] - count[i]);
            }
        }
        return res.stream().allMatch(i -> i <= 0);
    }

}
