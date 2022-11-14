package com.shuatmd.leetcodetraining.Easy;

import java.util.Stack;

public class MinStack30 {
    //Solution:使用辅助栈来达成效果 辅助栈b只添加比当前peek小的数字
    Stack<Integer> A, B;

    public MinStack30() {
        A = new Stack<>();
        B = new Stack<>();
    }
    //触发push时,往a栈中直接添加元素，如果b栈为空或者添加的元素小于b的peek则添加
    //使用>=是为了防止相同数被pop出，b始终保持有一个最小的数 eg 0→1→0 如果是== 则只会记录一个0 被排出后就没有最小值
    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x)
            B.add(x);
    }
    //触发pop时，a正常pop，判断a中pop的数是否与b的最后一位相等，如果不相等则不执行pop
    public void pop() {
        //用equals防止int不在[-127,128]范围内时判断引用地址
        if (A.pop().equals(B.peek()))
            B.pop();
    }

    public int top() {
        return A.peek();
    }
    //返回b栈的peek 永远为a中最小的数
    public int min() {
        return B.peek();
    }
}
