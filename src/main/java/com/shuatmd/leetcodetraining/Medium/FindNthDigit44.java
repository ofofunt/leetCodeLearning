package com.shuatmd.leetcodetraining.Medium;

import freemarker.template.utility.StringUtil;

//剑指 Offer 44. 数字序列中某一位的数字
//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
//
//请写一个函数，求任意第n位对应的数字。
public class FindNthDigit44 {
    //将此题分为三个步骤,首先找到n对应数字的位数,其次找到n对应的数字具体是什么,再然后需要n在对应数字中所对应的位数
    //例子: 当n  = 11
    // 第一步先找到n所对应的位数,因为180>11>9所以n指定的是两位数
    // 第二步通过11-9=2可以知道n指定的数是10
    // 第三步通过判断出来n所指的是10的第二位数
    // 返回0
    public int findNthDigit(int n) {
        //首先需要找出n对应数字的位数
        //从个位数开始, digit = 1, start = 1 ,count代表个位数可能出现的所有数 = 9
        int digit = 1;
        //注意要用long
        long start = 1;
        long count = 9;
        long num = 0;
        //第一步: 当n大于当前count,证明n所指定的数字不在当前位数,执行进位操作
        while (n - count > 0){
            n -= count;
            digit += 1;
            start *= 10;
            //count数量 = 第一位数的可能性（9） * 剩下位数的可能性（10/100/1000....） * 位数
            count = 9 * start * digit;
        }
        //第二步: while结束可以确定n所指定的数字的位数,此时再去查询n所指定的数字具体是什么
        num = start + (n-1)/digit;

        //第三步: 找寻n对应num的位数
        return Long.toString(num).charAt((n - 1) % digit) - '0';
        // char - '0' 可以直接转换为int 如果不减0则会显示数字的对应编码
        // 实际上 - ‘0’ 是减去0的对应编码48
    }

    public static void main(String[] args) {
        char a = '3';
        int b = a;
        int c = a - '0';
        System.out.println(b);
        System.out.println(c);
    }
}
