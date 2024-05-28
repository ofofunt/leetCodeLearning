package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

//313. 超级丑数
//超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
//
//给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
//
//题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
public class NthSuperUglyNumber313 {
    //官方解法1： 这题和之前丑数的题不同,之前得题都是给定你丑数的质因数,这道题变成给一个数组你
    //如果用最小最小堆做时间复杂度是n^2 回超时 需要用之前提及过的dp来做
    //dp的思路还是和之前得题目差不多 之前给定3个数字的情况下的dp公式为 dp[i] = min(2 * dp[p2], 3 * dp[p3], 5* dp[p5]
    public int nthSuperUglyNumber(int n, int[] primes) {
        int p = primes.length;
        int[] pointer = new int[p];
        Arrays.fill(pointer, 0);
        int[] dp = new int[n];
        dp[0] = 1;
        int[] curentValus = new int[p];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < p; j++) {
                curentValus[j] = dp[pointer[j]] * primes[j];
                if (curentValus[j] < 0) {
                    continue;
                } else {
                    // 超出int范围的情况
                    min = Math.min(min, curentValus[j]);
                }
            }
            dp[i] = min;
            for (int j = 0; j < p; j++) {
                if (curentValus[j] == min) {
                    pointer[j]++;
                }
            }
        }
        return dp[n-1];
    }
}
