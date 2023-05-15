package com.shuatmd.leetcodetraining.Medium;
//剑指 Offer II 010. 和为 k 的子数组
//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK010 {
    //解法1: 前缀和
    //因为数字存在负数,不能用滑动窗口做
    //通过一个Map来记录累加的和,通过map中元素的加减可以查询到所有连续和的可能性
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer,Integer> sumMap = new HashMap<>();
        //将(0,1)加入表中做初始化,存在首位数字满足target的情况
        sumMap.put(0,1);
        for (int num : nums) {
            sum +=num;
            res += sumMap.getOrDefault(sum - k,0);
            //需要记录所有可能达成sum的次数,因为有负数和0的存在,所以存在多种组合
            sumMap.put(sum, sumMap.getOrDefault(sum,0) + 1);
        }
        return res;
    }
}
