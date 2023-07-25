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
    //解法2: 还是滑动窗口 但是优化对比逻辑
    //diff逻辑, 只有t中出现的++ 如果为正则说明t中有,窗口中还没有
    public String minWindowAdv(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        int diff = 0;
        if(nt > ns){
            return "";
        }
        int[] count = new int[60];
        //记录初始窗口与目标字符串相差哪几个字母
        //如果count[i]大于0 则说明在t中有 在当前窗口没有
        //如果count[i] == 0 则说明t和当前窗口都有
        //如果count[i]小于0 则说明在t中没有 在当前窗口有 ->不需要关注
        for (int i = 0; i < nt; i++) {
            count[t.charAt(i) - 'A'] ++;
            count[s.charAt(i) - 'A'] --;
        }
        for (int i : count) {
            if(i > 0){
                diff ++;
            }
        }
        //因为存在唯一解,所以如果初始窗口与t一模一样则说明当前窗口就是最小的解
        if(diff == 0){
            return s.substring(0,nt);
        }
        int l = 0;
        int r = nt;
        int rmin = ns;
        int lmin = 0;
        for(;r < ns; r ++){
            int in = s.charAt(r) - 'A';
            count[in] -- ;
            //如果count为0说明减少了1次diff
            if(count[in] == 0){
                diff -- ;
            }
            if(diff != 0){
                continue;
            }
            //当找到符合条件的窗口之后,尝试左边滑动,开始缩小窗口大小
            for(;diff == 0; l++){
                int out = s.charAt(l) - 'A';
                count[out] ++;
                if(count[out] == 1){
                    diff ++;
                }
            }
            if(r - l + 1 < rmin - lmin){
                lmin = l -1;
                rmin = r;
            }
        }
        return rmin == ns? "" : s.substring(lmin, rmin + 1);
    }
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
