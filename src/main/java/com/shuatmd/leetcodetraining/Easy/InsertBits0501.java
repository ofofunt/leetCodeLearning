package com.shuatmd.leetcodetraining.Easy;
//面试题 05.01. 插入
//给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
//
//编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
//https://leetcode.cn/problems/insert-into-bits-lcci/
public class InsertBits0501 {
    //手搓解法1： 通过位计算解决
    public int insertBits(int N, int M, int i, int j) {
        //首先将n分为三等分
        int left = N >> j >> 1;
        //复原左边部分的位数同时补0
        left = left << j << 1;
        //补全需要拼凑的中间的部分
        int middle = M << i;
        //通过&找到右边部分的数字
        int right =  N & ((1<<i) - 1);
        return left | middle | right;
    }
}
