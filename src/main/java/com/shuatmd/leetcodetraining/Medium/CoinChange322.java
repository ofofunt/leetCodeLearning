package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

public class CoinChange322 {
    //官方解法1： dp 其实解法类似爬楼梯
    //递推公式： 假设f(i)为金额数量为i时需要的最少货币量
    //假设目前的货币为1,2,5
    //则有f(i) = Math.min(f(i-1),f(i-2),f(i-3)) + 1
    public int coinChangeDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if(i >= coin){
                    dp[i] = Math.min(dp[i - coin] + 1,dp[i]);
                }
            }
        }
        return dp[amount] < max? dp[amount]:-1;
    }
    //手搓解法： 贪心 + dfs
    //不会写回溯 得修改一下
    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        mincoin(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? res : -1;
    }

    private void mincoin(int[] coins, int amount, int index, int count) {
        //终止条件：amount为0
        //因为贪心出来的不一定是最优解,所以还是需要遍历所有的解法
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        //如果index小于0了直接返回 不需要继续dfs了
        if (index < 0) {
            return;
        }
        for (int i = amount / coins[index]; i >= 0 && i + count < res; i++) {
            mincoin(coins, amount - (i * coins[index]), index - 1, count + i);
        }
    }

    public static void main(String[] args) {
        CoinChange322 coin = new CoinChange322();
        coin.coinChangeDp(new int[]{1, 7, 10}, 14);
    }
}
