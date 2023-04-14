package com.shuatmd.leetcodetraining.Easy;
//剑指 Offer 65. 不用加减乘除做加法
//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
public class ImplementAdd65 {
    //解法1： 通过位算法来实现
    //使用逐位计算来实现
    //a 异或 b 算出a b相加之后的不算进位的值 s
    //a & b << 1来算出需要进位的值 n
    // 例子： 6 + 3 =    1 1 0 +  0 1 1
    // 1 1 0 ^ 0 1 1 = 1 0 1
    // 1 1 0 & 0 1 1 << 1 = 0 1 0 << 1 = 1 0 0
    // 结果等于 1 0 1 + 1 0 0 = 1 0 0 1 = 9
    public int add(int a, int b) {
        //循环计算 s + n 直到进位n 为0
        //进位n为时 说明 s = n = 最终结果
        int s = a;
        while(b != 0){
            int c = (s & b) << 1;
            s ^= b;
            b = c;
        }
        return s;
    }
}
