package com.shuatmd.leetcodetraining.Easy;
//剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
//给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
public class CountBits003 {
    //解法1：朴素模拟法
    //因为已知n小于10000 所以最多只用执行32次取位数操作
    //通过CountBit来循环计算出当前数字的包含1的个数 之后返回
    public int[] countBits(int n) {
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = countDigits(i);
        }
        return res;
    }

    private int countDigits(int i) {
        int ans = 0;
        for (int j = 0; j < 32; j++) {
            ans += (i >> j) & 1;
        }
        return ans;
    }

    //解法2:Dp实现
    //设dp[i]为第i位数时二进制包含的1的数量的总合
    //根据奇偶情况来分别讨论
    //假如i为奇数,则dp[i] = dp[i - 1] + 1 偶数的二进制最后一位一定不等于1,当为奇数的时候需要把尾部修改成1
    //假如i为偶数,则dp[i] = dp[i / 2] 偶数二进制除以2实际上是整体右移一位,去掉尾部的0 所以包含1的个数一定还是相等
    //二者合并 则可以得出dp[i] = dp[i / 2] + i % 2
    public int[] countBitsDp(int n) {
        int[] ans = new int[n +1];
        ans[0] = 0;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
