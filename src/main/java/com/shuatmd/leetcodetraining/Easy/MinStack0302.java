package com.shuatmd.leetcodetraining.Easy;

import java.util.Stack;

//面试题 03.02. 栈的最小值
//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
//https://leetcode.cn/problems/min-stack-lcci/
public class MinStack0302 {
    //手搓解法： 添加一个辅助栈,记录对应阶段的stack的最小值
    //注意 用Deque更好 可以直接peek
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack0302() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        int size = stack.size() - 1;
        if (minStack.size() == 0) {
            minStack.push(x);
        } else {
            int currMin = minStack.get(size - 1);
            minStack.push(currMin < x ? currMin : x);
        }
    }

    public void pop() {
       stack.pop();
       minStack.pop();

    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }
}
