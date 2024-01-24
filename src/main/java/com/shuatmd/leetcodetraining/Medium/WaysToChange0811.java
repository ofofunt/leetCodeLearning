package com.shuatmd.leetcodetraining.Medium;

//面试题 08.11. 硬币
//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
public class WaysToChange0811 {
    //官方解法1： dp
    //才用和爬楼梯差不多的dp公式,但是有区别
    //爬楼梯时1 2 3/1 3 2算2中不同的爬楼梯方法 但是这题的找零中 5 1 和 1 5 算为同一种解法
    public int waysToChange(int n) {
        //创建一个dp数组, dp[k]表示k分有几种表示法
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] coins = {1, 5, 10, 25};
        //dp公式 while(k - coin) == 0  dp[k] += dp[k - coin]

        //注意循环的时候要将coin循环放在外面
        //补充说明：为什么正确解法的coin要在外面？
        //
        //因为这样可以保证使用第二个硬币尝试的时候，dp中 只有 第一个硬币 尝试的结果
        //
        //即：
        //
        //dp[6]在使用第一个硬币时，等于dp[5] =1。
        //
        //dp[6]在使用第二个硬币时，等于dp[1] = 1(这是第一个硬币的组合结果)
        //
        //而错误解法中，dp[6]在第一个硬币尝试的时候，即dp[5]中有 尝试第一个、第二个硬币 的结果。

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
