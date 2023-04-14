package com.shuatmd.leetcodetraining.Medium;
//剑指 Offer 64. 求1+2+…+n
//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
public class SumNumbers64 {
    int[] nums = new int[]{0};
    //正经解法,用逻辑短路来终止递归
    public int sumNums(int n) {
        boolean x = n > 1 && (n+=sumNums(n -1))> 0;
        return n;
    }

    //搞怪解法1：
    public int sumNumsException(int n) {
        try{
            return nums[n];
        }
        catch (Exception e) {
            return n + sumNumsException(n - 1);
        }
    }
}
