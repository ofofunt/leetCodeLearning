package com.shuatmd.leetcodetraining.Easy;

//剑指 Offer II 001. 整数除法
//给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
public class ImplementDivide001 {
    public int divide(int a, int b) {
        int sign = (a > 0 && b > 0) || (a < 0 && b < 0) ? 1 : -1;
        int res = 0;
        int divide = Math.abs(a) - Math.abs(b);

        while (divide >= 0) {
            divide -= Math.abs(b);
            res++;
        }
        return sign * res;
    }
}
