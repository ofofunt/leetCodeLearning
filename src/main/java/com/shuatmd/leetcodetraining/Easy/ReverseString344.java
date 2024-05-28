package com.shuatmd.leetcodetraining.Easy;
//344. 反转字符串
//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
//不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//https://leetcode.cn/problems/reverse-string/description/
public class ReverseString344 {
    //手搓解法： 双指针 头尾互换 如果长度为奇数,刚好奇数位不用管
    public void reverseString(char[] s) {
        int tail = s.length - 1;
        for (int i = 0; i < s.length/2; i++) {
            char swap = s[i];
            s[i] = s[tail];
            s[tail] = swap;
            tail --;
        }
    }

    public static void main(String[] args) {
        ReverseString344 reverseString344 = new ReverseString344();
        reverseString344.reverseString(new char[]{'h','e','l','l','o'});
    }
}
