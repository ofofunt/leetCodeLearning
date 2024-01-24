package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

//面试题 16.26. 计算器
//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
//
//表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
//https://leetcode.cn/problems/calculator-lcci/description/
public class Calculator1626 {
    //官方解法1： 用栈来计算
    //难点： 需要优先考虑乘除 再考虑加减
    //解法: 通过栈的先进后出机制来实现
    //首先将第一个数字放入栈中 判断连接的计算符号
    //如果是 + 则直接将后一位数字放入栈中
    //如果是 - 则直接将后一位数字的负数放入栈中
    //如果是 * 则将栈中最后一个加入的数字pop出计算出相乘的结果放入栈中
    //如果是 / 则将栈中最后一个加入的数字pop出计算出相除的结果放入栈中
    public int calculate(String s) {
        char[] charArray = s.trim().toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < charArray.length; i++) {
            //判断如果多位数字,需要取到数字的总和
            if (Character.isDigit(charArray[i])) {
                num = num * 10 + charArray[i] - '0';
            }
            //除了加减乘除以及数字外 还需要判断空格,如果为空格则直接跳过
            //取出第一个数时 默认符号为 加 将其放入栈中
            //判断计算的节点是出现加减乘除符号 或者已经走到string最后一位
            if (!Character.isDigit(charArray[i]) && charArray[i] != ' ' || i == charArray.length - 1) {
                switch (preSign) {
                    //如果为加减 则直接放入栈的尾部
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    //如果为乘除,则先计算结果之后放入栈的尾部
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                preSign = charArray[i];
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
