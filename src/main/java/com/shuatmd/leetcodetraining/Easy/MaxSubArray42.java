package com.shuatmd.leetcodetraining.Easy;
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
//要求时间复杂度为O(n)
public class MaxSubArray42 {
    public int maxSubArray(int[] nums) {
        //用dp的方法来解决
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ///nums[i-1]如果为整数,表示之前的和为正数,那nums[i]加上之前的和
            //nums[i-1]如果为负数,则证明nums[i]受到之前负数的影响,nums[i]使用当前的数而不是再用之前的和来累加
             nums[i] = Math.max(0,nums[i-1]) + nums[i];
             //res保留最高的连续相加的和
             res = Math.max(nums[i],res);
        }
        return res;
    }
}
