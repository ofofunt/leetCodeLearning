package com.shuatmd.leetcodetraining.Easy;

//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
public class WaysToStep0801 {
    //官方解法1：用dp做 dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
    public int waysToStep(int n) {
        if(n<3){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] + dp[i -3]) % 1000000007) % 1000000007;
        }
        return dp[n];
    }
}
