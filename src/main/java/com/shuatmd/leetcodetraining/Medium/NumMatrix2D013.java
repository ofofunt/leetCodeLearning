package com.shuatmd.leetcodetraining.Medium;
//剑指 Offer II 013. 二维子矩阵的和
//给定一个二维矩阵 matrix，以下类型的多个请求：
//计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
//实现 NumMatrix 类：
//NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
//int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
public class NumMatrix2D013 {
    int[][] sums;
    //解法2: 用2d的前缀和来求和 具体解法
    // https://leetcode.cn/problems/O4NDxx/solutions/1028794/jian-zhi-offer-zhuan-xiang-tu-po-ban-shu-5lks/
    //2d区域求前缀和,类似求共同面积
    public NumMatrix2D013(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
