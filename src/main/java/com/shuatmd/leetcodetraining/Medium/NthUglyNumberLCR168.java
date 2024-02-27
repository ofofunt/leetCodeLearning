package com.shuatmd.leetcodetraining.Medium;
//https://leetcode.cn/problems/chou-shu-lcof/description/
//LCR 168. 丑数
//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
//说明：丑数是只包含质因数 2、3 和/或 5 的正整数；1 是丑数。
public class NthUglyNumberLCR168 {
    //手搓解法1：多路合并 参考NthUglyNumber49
    public int nthUglyNumber(int n) {
        int[] factors = new int[]{2,3,5};
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int nums[] = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            nums[i] = Math.min(Math.min(nums[p2] * 2, nums[p3] * 3), nums[p5] * 5);
            if(nums[i] == nums[p2] * 2){
                p2 ++;
            }
            if(nums[i] == nums[p3] * 3){
                p3 ++;
            }
            if(nums[i] == nums[p5] * 5){
                p5 ++;
            }
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        NthUglyNumberLCR168 test = new NthUglyNumberLCR168();
        test.nthUglyNumber(10);
    }
}
