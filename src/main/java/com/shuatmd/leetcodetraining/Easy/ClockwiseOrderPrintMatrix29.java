package com.shuatmd.leetcodetraining.Easy;

public class ClockwiseOrderPrintMatrix29 {
    //Solution:通过设定边界，循环打印
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return null;
        }
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            //从左到右打印，碰到右边界之后t+1，如果t = b则说明已经完全打印
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            //从右上角到右下角进行输出，当输出完毕时，右边界-- 再从右往左进行输出
            // 当左大于右时 证明已经打印完毕
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if (l > --r) {
                break;
            }
            //从右下角往左下角打印，打印完毕之后下边框-1
            //如果下边框小于上边框 则表示打印完毕
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if (t > --b) {
                break;
            }
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l]; // bottom to top.

            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        ClockwiseOrderPrintMatrix29 clockwiseOrderPrintMatrix = new ClockwiseOrderPrintMatrix29();
        clockwiseOrderPrintMatrix.spiralOrder(matrix);
    }
}
