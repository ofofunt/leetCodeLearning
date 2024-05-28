package com.shuatmd.leetcodetraining.Easy;
//342. 4的幂
//给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
//
//整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
//https://leetcode.cn/problems/power-of-four/description/
public class IsPowerOfFour342 {
    //官方解法1： 数学取模
    //4 ^x = (3 +1)^x 通过多项式我们可知 结果等于 3^x + 1^x + (多项式部分) 且多项式部分一定能被3整除
    //由此可知 4的幂次方被3整除永远剩下1
    //同时我们要判断n是否为2的幂 因为如果为2的幂一定是4的幂
    //可以通过n & (n - 1)来判断是否为2的幂
    //仔细展开一下n & (n - 1) 的作用是移除数字二进制最后一位的1
    //example : 5 -> 1 0 1   5 - 4 = 2 -> 1 0 0  101 & 100 = 100
    //因为2的幂一定只存在1位1 所以移除之后剩下的所有数自然就等于0
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n &(n - 1)) == 0 && n %3 == 1;
    }
}
