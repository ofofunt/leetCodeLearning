package com.shuatmd.leetcodetraining.Medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//面试题 03.05. 栈排序
//栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
//https://leetcode.cn/problems/sort-of-stacks-lcci/
public class SortedStack0305 {
    //官方解法： 在push时暂存一个有序的stack 通过惰性更新来实现
    //原始栈
    Deque<Integer> stack = new LinkedList<>();
    //辅助栈
    Deque<Integer> tmp = new LinkedList<>();
    public SortedStack0305() {

    }

    public void push(int val) {
        int max = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
        int min = tmp.isEmpty() ? Integer.MIN_VALUE : tmp.peek();
        //比较原始栈与辅助栈栈顶值，使其满足 辅助栈 <= val <= 原始栈
        while(true){
            if(val > max){
                tmp.push(stack.pop());
                max = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
            }
            else if(val < min){
                stack.push(tmp.pop());
                min = tmp.isEmpty() ? Integer.MIN_VALUE : tmp.peek();
            }
            else{
                stack.push(val);
                break;
            }
        }

        //比较原始栈和辅助栈顶值，使其满足辅助栈<= val <= 原始栈
//        while(!stack.isEmpty() && stack.peek() < val) {
//            tmp.push(stack.pop());
//        }
//        while(!tmp.isEmpty() && tmp.peek() > val) {
//            stack.push(tmp.pop());
//        }
//        stack.push(val);
//        或放到tmp中tmp.push(val);
    }

    public void pop() {
        //将辅助栈元素push回原始栈
        while (!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
        if (!stack.isEmpty())
            stack.pop();
    }

    public int peek() {
        //将辅助栈元素push回原始栈
        while (!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty() && tmp.isEmpty();
    }
}
