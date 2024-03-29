package com.shuatmd.leetcodetraining.Easy;

//面试题 17.01. 不用加号的加法
//设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
//https://leetcode.cn/problems/add-without-plus-lcci/description/
public class Add1701 {
    //官方解法1： 运用位运算 一位一位来实现计算
    //位数相加的无进位结果可以通过异或来表示 比如 0 + 1 = 1 ; 1 + 1 = 0
    //所有需要进位的位为 a&b 进位后的结果为 a&b << 1
    public int add(int a, int b) {
        //以 a = 5 和 b = 7 为例来解释这段代码的工作原理。
        //
        //首先，我们计算不进位加法结果 m = a ^ b。5 的二进制表示是 101，7 的二进制表示是 111，所以 m = 101 ^ 111 = 010，对应的十进制数是 2。
        //
        //然后，我们计算进位 n = (a & b) << 1。a & b = 101 & 111 = 101，左移一位后得到 1010，对应的十进制数是 10。
        //
        //现在，我们有 m = 2 和 n = 10。因为 n 不等于 0，所以我们进入循环。
        //
        //在循环中，我们首先计算新的不进位加法结果 temp = n ^ m = 10 ^ 2 = 8，然后计算新的进位 n = (m & n) << 1 = (2 & 10) << 1 = 0，最后更新不进位加法结果 m = temp = 8。
        //
        //现在，我们有 m = 8 和 n = 0。因为 n 等于 0，所以我们退出循环。
        //
        //最后，我们返回不进位加法结果 m = 8，这就是 a = 5 和 b = 7 的和。
        //
        //所以，这段代码返回的结果是 8，这是正确的。


        //简单来说就是将计算分为两部分 不进位的和 以及只进位的和
        //再循环相加两者 直到进位为0 说明已经完成计算
        int carry = 0;
        //当进位的结果等于0 说明不再需要进位 两者相加就是结果
        while (b != 0) {
            carry = (a & b) << 1;
            //将a设置成不进位的和
            a = a ^ b;
            //b设置为只进位的部分
            b = carry;
        }
        return a;
    }
}
