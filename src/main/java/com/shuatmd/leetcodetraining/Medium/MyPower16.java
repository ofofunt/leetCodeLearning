package com.shuatmd.leetcodetraining.Medium;

public class MyPower16 {
    //Solution 1: 简单直接粗暴版，会超时 不要用
    public double myPow(double x, int n) {
        double res = x;
        if(n > 1) {
            for (int i = 1; i < n; i++) {
                res *= x;
            }
        } else if (n < 0) {
            res = 1/x;
            for (int i = 1; i < Math.abs(n); i++) {
                res *= 1/x;
            }
        }
        else if(n == 0){
            return 1.0;
        }

        return res;
    }


    //Solution2： 二分法版本将x的n次方转变成x平方乘以x的（n/2)次
    //通过不断对自己平方来缩小n/2的值 直到n变为0
    //如果n无法被2整除 则将余数单独乘出来
    public double myPow2(double x, int n) {
        if(n ==0){
            return 1;
        }
        double res = 1;
        long val = n;
        while(val!=0){
            if(val <0){
                val = -val;
                x = 1/x;
            }
            if((val&1) !=0){
                res *= x;
            }
            x *= x;
            val>>=1;
        }
        return res;
    }

    public static void main(String[] args) {
        MyPower16 myPower = new MyPower16();
        System.out.println(myPower.myPow2(2.0,2147483647));
    }
}
