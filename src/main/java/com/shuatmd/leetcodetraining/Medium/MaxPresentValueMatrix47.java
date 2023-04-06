package com.shuatmd.leetcodetraining.Medium;

//剑指 Offer 47. 礼物的最大价值
//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
// 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
// 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
public class MaxPresentValueMatrix47 {
    //用dp的解法去做,结果集dp[i][j]
    //判断每条路径中的和的最大值
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当i j都为0时,代表还在起点,通过continue直接跳过
                if (j == 0 && i == 0) {
                    continue;
                }
                //当i=0 j不为0时候,是只在往右移动,累加即可模拟出一直往右走的路线
                else if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                //当j=0 i不为0时候,是只在往下移动,累加即可模拟出一直往下走的路线
                else if (j == 0 && i != 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                //当i,j均不为0,则根据i j-1和i-1 j来判断当前点的可能最大值
                else {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
