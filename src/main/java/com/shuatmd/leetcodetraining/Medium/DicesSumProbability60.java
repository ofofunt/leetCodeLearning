package com.shuatmd.leetcodetraining.Medium;

public class DicesSumProbability60 {
    //递归解法1：通过递归公式来做
    public double[] dicesProbabilityRecur(int n) {
        //假设我们已经知道有n - 1个骰子的时候,骰子和的概率,递推当有n个骰子,且骰子和为x的情况
        //f(n,x) = (f(n-1,x-1) + f(n-1,x-2) + f(n-1,x-3) + f(n-1,x-4) + f(n-1,x-5) + f(n-1,x-6)) /6
        //此时能生成递推公式 f(n, x) = cigma(i = 1, 6) (f(n -1, x - i) * 1/6
        int maxSum = 6 * n;
        double[]count = new double[maxSum - n + 1];
        int index = 0;
        for (int i = n; i <= maxSum ; i++) {
            count[index++] = recur(n,i);
        }
        return count;
    }

    private double recur(int n, int i) {
        if(i < n || i > 6 * n){
            return 0.0;
        }
        if(n == 1){
            return 1.0/6.0;
        }
        return (recur(n -1 , i - 1) + recur(n -1 , i - 2) + recur(n -1 , i - 3)
                + recur(n -1 , i - 4) +recur(n -1 , i - 5) + recur(n -1 , i - 6)) / 6.0;
    }

    //暴力解法：主要用于理解题目,对n个骰子进行遍历
    public double[] dicesProbabilityBruteForce(int n) {
        int maxSum = 6 * n;
        int[] count = new int[maxSum - n + 1];
        dfs(n, 0, count, n);
        double[] ans = new double[maxSum - n + 1];
        double all = Math.pow(6, n);
        for (int i = n; i <= maxSum; i++) {
            ans[i - n] = count[i - n] / all;
        }
        return ans;
    }
    //通过递归来统计所有骰子的可能出现情况,并且记录
    private void dfs(int n, int sum, int[] count, int origin) {
        //n代表骰子的个数,如果n == 0 则代表所有骰子已经算完
        if (n == 0) {
            count[sum - origin]++;
            return;
        }
        for (int i = 1; i <= 6; i++) {
            dfs(n - 1, sum + i, count, origin);
        }
    }
}
