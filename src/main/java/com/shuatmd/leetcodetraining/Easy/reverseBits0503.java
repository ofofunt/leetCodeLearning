package com.shuatmd.leetcodetraining.Easy;

//面试题 05.03. 翻转数位
//给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
//https://leetcode.cn/problems/reverse-bits-lcci/description/
public class reverseBits0503 {
    //手搓尝试 循环+维护两个数
    public int reverseBits(int num) {
        //当前连续1的次数
        int current = 0;
        //通过reverse1次能获得的连续次数
        int reverse = 0;
        int max = 0;
        //最大32位 所以循环32次最多
        for (int i = 32; i > 0; i--) {
            //当前位数是1 则curr和reverse都加1
            if ((num & 1) == 1) {
                current++;
                reverse++;
            }
            //当前数是0,则reverse还能通过翻转延续,而curr要做归0
            else {
                reverse = current + 1;
                current = 0;
            }
            if(reverse>max){
                max = reverse;
            }
            //当前位数判断结束,右移一位
            num >>= 1;
        }
        return max;
    }
}
