package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/contiguous-sequence-lcci/
//面试题 16.17. 连续数列
//给定一个整数数组，找出总和最大的连续数列，并返回总和。
public class MaxSubArray1617 {
    //手搓解法2：尝试dp做
    //dp公式 如果dp(i - 1) > 0 dp(i) = nums[i] + dp[i - 1]
    //否則dp[i] = nums[i]
    public int maxSubArrayDp(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 0){
            return 0;
        }
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i - 1] > 0){
                dp[i] = nums[i] + dp[i -1];
            }
            else {
                dp[i] = nums[i];
            }
            maxSum = Math.max(dp[i],maxSum);
        }
        return maxSum;
    }
    //手搓解法1： 将连续和记录在List当中,返回List中的最大数-最小数
    //不对 无法排序 可能出现 前面的和减去后面的和的情况
    public int maxSubArray(int[] nums) {
        List<Integer> subList = new ArrayList<>();
        if (nums.length <= 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            if (nums[0] < 0 || nums[1] < 0) {
                return nums[0] > nums[1] ? nums[0] : nums[1];
            } else {
                return nums[0] + nums[1];
            }
        }
        int sub = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sub += nums[i];
            subList.add(sub);
        }
        return subList.stream().max(Integer::compareTo).get() - subList.stream().min(Integer::compareTo).get();

    }
}
