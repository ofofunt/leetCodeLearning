package com.shuatmd.leetcodetraining.Medium;
//剑指 Offer 49. 丑数
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
public class NthUglyNumber49 {
    //使用dp来做
    //dp[n]为第n个丑数 那dp[n]一定是min(dp[a] * 2 , dp[b] * 3, dp[c] * 5)
    //需要计算dp[i]和dp[a] * 2 , dp[b] * 3, dp[c] * 5之间的关系
    //如果相等则需要更新索引加一
    //初始状态dp[0] = 1
    public int nthUglyNumber(int n) {
        int a = 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            int min = Math.min(n2,Math.min(n3,n5));
            dp[i] = min;
            if(n2 == min){
                a++;
            }
            if(n3 == min){
                b++;
            }
            if(n5 == min){
                c++;
            }
        }
        return dp[n -1];
    }
}
