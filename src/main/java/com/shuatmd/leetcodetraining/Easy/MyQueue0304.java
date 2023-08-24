package com.shuatmd.leetcodetraining.Easy;

import java.util.Stack;

//面试题 03.04. 化栈为队
//实现一个MyQueue类，该类用两个栈来实现一个队列。
//你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
//你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
//假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
//https://leetcode.cn/problems/implement-queue-using-stacks-lcci/
public class MyQueue0304 {
    //手搓尝试,用两个Stack 一正一反 来记录
    //感觉有点太太太麻烦了
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    /** Initialize your data structure here. */
    public MyQueue0304() {
        this.popStack = new Stack<>();
        this.pushStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(!popStack.isEmpty()){
            while(!popStack.isEmpty()){
                pushStack.push(popStack.pop());
            }
        }
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popStack.isEmpty() && pushStack.isEmpty()){
            return -1;
        }
        if(!pushStack.isEmpty()) {
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }

        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
     if(popStack.isEmpty()&&pushStack.isEmpty()){
         return -1;
     }
     if(!popStack.isEmpty()){
         return popStack.peek();
     }
     while(!pushStack.isEmpty()){
         popStack.push(pushStack.pop());
     }
     return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty()&&popStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue0304 myQueue = new MyQueue0304();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.peek();
        myQueue.pop();
        myQueue.empty();
    }
}
