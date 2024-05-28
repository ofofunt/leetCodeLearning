package com.shuatmd.leetcodetraining.Medium;

//343. 整数拆分
//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
//
//返回 你可以获得的最大乘积 。
//https://leetcode.cn/problems/integer-break/description/
public class IntegerBreak343 {
    //官方解法： 数学
    //从数学求导可知 以3为因数分解可以获得最大值
    public int integerBreak(int n) {
        if(n <= 3){
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        //如果当前数能被3整除,则最大乘积就是3^n
        if(b == 0){
            return (int) Math.pow(3,a);
        }
        //如果当前数被除的余数为1 则将最后一个3转换成2 + 1 最大乘积变成 3^(n - 1) * (2 * 2)
        if(b == 1){
            return (int) Math.pow(3,a-1) * 4;
        }
        //如果当前数被除的余数为2,则直接乘以2
        return (int) Math.pow(3,a) * 2;

    }
}
