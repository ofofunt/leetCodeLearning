package com.shuatmd.leetcodetraining.Medium;

//面试题 16.01. 交换数字
//编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
//https://leetcode.cn/problems/swap-numbers-lcci/description/
public class SwapNumbersWithoutTmp1601 {
    //官方推荐解法：xor -> a^b^b = a  a^a^b = b
    public int[] swapNumbersOfficial(int[] numbers) {
        //此时numbers[0]为a^b
        numbers[0] ^= numbers[1];
        //a^b^b = a
        numbers[1] ^= numbers[0];
        //a^b^a = a
        numbers[0] ^= numbers[1];
        return numbers;
    }
    //官方简单解法1：用加法(减法也是同理)来实现
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }
}
