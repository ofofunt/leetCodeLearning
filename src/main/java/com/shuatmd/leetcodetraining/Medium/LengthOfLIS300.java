package com.shuatmd.leetcodetraining.Medium;
//300. 最长递增子序列
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
//子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
//https://leetcode.cn/problems/longest-increasing-subsequence/description/
public class LengthOfLIS300 {
    //官方解法1： dp
    //dp[i] 代表第i位 的最长递增子数列的长度
    //dp[i] = max(dp[j]) + 1
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                //对于当前位置j 需要轮询遍历之前的所有位置
                //假设j = 9 i =3
                //假设d[i] = 2 证明前三位子序列包含一个长度为2的递增序列
                //此时如果dp[j] > dp[i] 说明可以继续维持递增 则dp[i]变为 2 + 1 =3
                //如果i = 8 假设dp[i] = 5
                //如果dp[j] < dp[i] 说明无法继续维持递增 最长的递增子序列还是5
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                //记录dp[i]的最大值
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
