package com.shuatmd.leetcodetraining.Medium;
//304. 二维区域和检索 - 矩阵不可变
//给定一个二维矩阵 matrix，以下类型的多个请求：
//
//计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
//实现 NumMatrix 类：
//
//NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
//int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。

public class NumMatrix304 {

    //官方解法：二位前缀和
    //先求出从(0,0)到(i,j)的前缀和 之后通过裁剪的到最终结果
    int[][] preSum;
    public NumMatrix304(int[][] matrix) {
        preSum = new int[matrix.length][matrix[0].length+1];
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

    }
    //手搓尝试
    //将矩阵转换为前缀和矩阵
    //之后循环求出每一列的sum 相加
    //缺点：还是需要循环 尝试看看有没有不要循环的办法
//    int[][] sumMatrix;
//    int res;
//    public NumMatrix304(int[][] matrix) {
//        sumMatrix = new int[matrix.length][matrix[0].length + 1];
//        for (int i = 0; i < matrix.length; i++) {
//            int sum = 0;
//            for (int j = 0; j < matrix[i].length; j++) {
//                sum = sum + matrix[i][j];
//                sumMatrix[i][j + 1] = sum;
//            }
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        res = 0;
//        for (int i = row1; i <= row2; i++) {
//            res += sumMatrix[i][col2+1] - sumMatrix[i][col1];
//        }
//        return res;
//    }

    public static void main(String[] args) {
        NumMatrix304 matrix = new NumMatrix304(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        matrix.sumRegion(2, 1, 4, 3);
        matrix.sumRegion(1, 1, 2, 2);
        matrix.sumRegion(1, 2, 2, 4);
    }
}
