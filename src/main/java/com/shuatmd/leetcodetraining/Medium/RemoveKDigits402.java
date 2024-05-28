package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

//402. 移掉 K 位数字
//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
//https://leetcode.cn/problems/remove-k-digits/description/
public class RemoveKDigits402 {
    //官方解法1： 也是贪心+栈
    public String removeKdigits(String num, int k) {
        char[] charArray = num.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int count = k;
        for (int i = 0; i < charArray.length; i++) {
            char cur = charArray[i];
            //判断 当当前的数小于栈顶的时候 将栈顶得数排出
            //注意 因为只移除k个数 所以同时也要判断k不能小于0
            while (!stack.isEmpty() && stack.peekLast() > cur && k > 0) {
                stack.removeLast();
                k--;
            }
            stack.offer(cur);
        }
        boolean leadingZero = true;
        //题目中写了最后结果会很长 必须用string处理 不能用int或者其他数字类型处理
        StringBuilder sb = new StringBuilder();
        //可能会存在没有移除满k次的情况 比如 1 2 3 4 5 我们就会移除0次
        //结果我们只用取queue中的前length - k位
        for (int i = 0; i < num.length() - count; i++) {
            char pop = stack.pop();
            if (leadingZero && pop == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(pop);
        }
        //需要考虑特殊情况 0
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits402 remove = new RemoveKDigits402();
        remove.removeKdigits("1432219", 3);
    }
}
