package com.shuatmd.leetcodetraining.Easy;
//338. 比特位计数
//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
//https://leetcode.cn/problems/counting-bits/description/
public class CountBits338 {
    //官方解法1：数学解法 + Dp
    //分成奇数以及偶数讨论
    //假如n为奇数 他所含有的1的数量永远比n - 1多1
    //假如n为偶数 他所含有的1的数量n/2相等 因为除以2本质是右移1位 偶数的最右位永远是0
    public int[] countBits(int n) {
        int result[] = new int[n + 1];
        //初始状态result[0] = 0
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            if(i % 2  == 1){
                result[i] = result[i  - 1] + 1;
            }
            else{
                result[i] = result[i/2];
            }
        }
        return result;
    }
}
