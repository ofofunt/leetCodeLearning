package com.shuatmd.leetcodetraining.Medium;
//剑指 Offer II 013. 二维子矩阵的和
//给定一个二维矩阵 matrix，以下类型的多个请求：
//
//计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
//实现 NumMatrix 类：
//
//NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
//int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
// 
public class NumMatrix {
    int [][] sums;
    //解法1： 1维前缀和 求出每一行的前缀和 之后分开计算每一行独立的和 然后叠加返回
    //时间复杂度O(mn)
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        if(n >0) {
            int l = matrix[0].length;
            //sums需要多占用一列,储存0（初始值）
            sums = new int[n][l + 1];
            for (int i = 0; i < n; i++) {
                for (int r = 1; r < l; r++) {
                    sums[n][r + 1] = sums[n][r] + matrix[n][r];
                }
            }
        }
    }
    //一维数组的部分和 = sum[i][col2 + 1] - sum[i][col1]
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <=row2 ; i++) {
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }
}
