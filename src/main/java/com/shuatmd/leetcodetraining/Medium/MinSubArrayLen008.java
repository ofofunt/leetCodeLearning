package com.shuatmd.leetcodetraining.Medium;
//剑指 Offer II 008. 和大于等于 target 的最短子数组
//给定一个含有 n 个正整数的数组和一个正整数 target 。
//找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
public class MinSubArrayLen008 {
    //解法1:滑动窗口 找到一个最小且和大于target的滑动窗口并且返回length
    //O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int ret = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while(sum >= target){
                ret = Math.min(ret, r - l + 1);
                sum -= nums[l++];
            }
        }
        return ret <= nums.length? ret: 0;
    }
}
