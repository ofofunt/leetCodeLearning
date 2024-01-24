package com.shuatmd.leetcodetraining.Easy;
//面试题 16.05. 阶乘尾数
//设计一个算法，算出 n 阶乘有多少个尾随零。
//https://leetcode.cn/problems/factorial-zeros-lcci/description/

public class TrailingZeroes1605 {
    //找尾随0的操作实际上是找n中包含的2 5因子的个数
    //因为2的因子数一定会大于5的因子数 所以只需要找5的因子数
    public int trailingZeroes(int n) {
        int res = 0;
        //需要找到5以及5的倍数的因子数 比如 5 25 125 所以需要累除
        while(n >=5 ){
            n = n/5;
            res+=n;
        }
        return res;
    }
}
