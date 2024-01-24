package com.shuatmd.leetcodetraining.Medium;

//面试题 10.09. 排序矩阵查找
//给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
//https://leetcode.cn/problems/sorted-matrix-search-lcci/
public class SearchMatrix1009 {
    //手搓解法1：从右上角或者左下角开始 进行排序
    public boolean searchMatrix(int[][] matrix, int target) {
        //排除特殊情况
        if (matrix.length == 0) {
            return false;
        }
        int y = 0;
        int x = matrix[0].length - 1;
        while (x >= 0 && y < matrix.length) {
            if (target == matrix[y][x]) {
                return true;
            } else if (target > matrix[y][x]) {
                y++;
            } else {
                x--;
            }
        }
        return false;
    }
}
