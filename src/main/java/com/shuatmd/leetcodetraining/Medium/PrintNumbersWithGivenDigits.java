package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

public class PrintNumbersWithGivenDigits {
    char[] num;
    int[] ans;
    int count = 0,n;
    //Solution1: 假设需要返回的int存在超过int32位限制的情况，需要改用string来储存int
    //通过将题目转换为n位数字的排列组合来实现
    //使用parseInt将左边的0删除 001 parseInt变成1
    public int[] printNumbers(int n) {
        this.n = n;
        num = new char[n];
        ans = new int[(int) (Math.pow(10, n) - 1)];
        dfs(0);
        return ans;
    }
    private void dfs(int n) {
        if (n == this.n) {
            String tmp = String.valueOf(num);
            int curNum = Integer.parseInt(tmp);
            if (curNum!=0) ans[count++] = curNum;
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[n] = i;
            dfs(n + 1);
        }
    }

    public static void main(String[] args) {
        PrintNumbersWithGivenDigits printNumbersWithGivenDigits = new PrintNumbersWithGivenDigits();

    }
}
