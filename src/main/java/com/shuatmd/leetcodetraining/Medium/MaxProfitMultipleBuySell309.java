package com.shuatmd.leetcodetraining.Medium;

//309. 买卖股票的最佳时机含冷冻期
//给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
//
//设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
public class MaxProfitMultipleBuySell309 {
    private int[] prices;
    private Integer[][] f;
    /*
    官方解法： Dp分情况讨论
    对于第i天 只会存在三种情况:
    dp[i][0]代表不持股且当天没卖出
    dp[i][1]代表持股
    dp[i][2]代表不持股且当天已经卖出

    初始化状态
    dp[0][0] = 0;
    dp[0][1] = -1 * price[0] 只买入没有卖出
    dp[0][2] = 0; 当日买入卖出

    状态转移方程：
    第i天不持股且当天也没有卖出： 存在两种情况： 1） i-1天没有持股 2）i-1天卖了,第i天没法卖
    dp[i][0] = max(dp[i-1][0],dp[i-1][2])
    第i天只持股不卖1： 存在两种情况：1）i-1天就持股 但是没有卖 2）i - 1天持股且没有卖,因为如果当天卖出会触发冷冻期 无法买入
    dp[i][1] = max(dp[i-1][1],dp[i-1][0]-p[i])    //因为第二种情况是当天买入 所以profit要减去当天的股价price[i]
    第i天不持股且当日已经卖出： 存在一种状态：i-1天持股 i天卖出
    dp[i][2] = dp[i-1][1] + p[i]
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[prices.length-1][2], Math.max(dp[prices.length-1][0], dp[prices.length-1][1]));

    }

    //官方解法2： DFS
    public int maxProfitDFS(int[] prices) {
        this.prices = prices;
        f = new Integer[prices.length][2];
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= prices.length) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = dfs(i + 1, j);
        if (j > 0) {
            ans = Math.max(ans, prices[i] + dfs(i + 2, 0));
        } else {
            ans = Math.max(ans, -prices[i] + dfs(i + 1, 1));
        }
        return f[i][j] = ans;
    }

    public static void main(String[] args) {
        MaxProfitMultipleBuySell309 maxProfit = new MaxProfitMultipleBuySell309();
        maxProfit.maxProfitDFS(new int[]{1,2,3,0,2});

    }
}
