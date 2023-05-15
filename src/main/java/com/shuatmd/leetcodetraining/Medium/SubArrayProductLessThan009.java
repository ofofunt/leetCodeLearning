package com.shuatmd.leetcodetraining.Medium;
//剑指 Offer II 009. 乘积小于 K 的子数组
//给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
public class SubArrayProductLessThan009 {
    //解法1：滑动窗口
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int product = 1;
        int res = 0;
        //找到乘积大于等于target的窗口
        //因为数组中的每个数都大于0,所以对于当前窗口有nums.length - r个大于target的值
        //遍历整个数组,得到所有大于target的解
        for (int r = 0; r < nums.length; r++) {
            product *= nums[r];
            while(product >= k && l<=r){
                product /= nums[l++];
                res = nums.length - r;
            }
        }
        //将所有可能性 - 大于target的可能性 可以得到正确的结果
        return (n + 1) * n /2 -  res;
    }
}
