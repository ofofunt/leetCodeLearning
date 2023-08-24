package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//面试题 03.03. 堆盘子
//堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
//
//当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
//https://leetcode.cn/problems/stack-of-plates-lcci/
public class StackOfPlates0303 {
    //官方解法：用List<Stack<Integer实现>>
    List<Stack<Integer>> plateStackList;
    int cap;

    public StackOfPlates0303(int cap) {
        this.plateStackList = new ArrayList<>();
        this.cap = cap;

    }

    public void push(int val) {
        //当cap为0或以下 不考虑
        if (cap <= 0) {
            return;
        }
        //当当前的List为空或者当前List最末位的Stack的size等于cap时,说明需要添加一个新的Stack到List里面
        if (plateStackList.isEmpty() || plateStackList.get(plateStackList.size() - 1).size() == cap) {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            plateStackList.add(stack);
            return;
        }
        //如果当前List尾部的Stack仍然有空间,则直接放入当前Stack
        plateStackList.get(plateStackList.size() - 1).push(val);
    }

    public int pop() {
        //pop操作实际上是popAt(最后一位) 所以直接调用popAt
       return popAt(plateStackList.size() - 1);
    }

    public int popAt(int index) {
        //存在index异常或者大于当前Stack的size的情况直接返回-1
        if(index < 0 || index >= plateStackList.size()){
            return -1;
        }
        //index合法的话判断当前index的Stack的长度 如果是空则返回-1
        Stack<Integer> integers = plateStackList.get(index);
        if(integers.isEmpty()){
            return -1;
        }
        //如果pop之后为空 则remove掉当前index的Stack
        Integer pop = integers.pop();
        if(integers.isEmpty()){
            plateStackList.remove(index);
        }
        return pop;
    }
}
