package com.shuatmd.leetcodetraining.Easy;
//三合一。描述如何只用一个数组来实现三个栈。
//你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
//
//构造函数会传入一个stackSize参数，代表每个栈的大小。
//https://leetcode.cn/problems/three-in-one-lcci/
public class TripleInOne0301 {
    //手搓解法： 二维数组模拟3个不同的栈 location数组模拟当前的栈指针
    int N = 3;
    // 3 * n 的数组，每一行代表一个栈
    int[][] data;
    // 记录每个栈「待插入」位置
    int[] locations;

    public TripleInOne0301(int stackSize) {
        data = new int[N][stackSize];
        locations = new int[N];
    }

    public void push(int stackNum, int value) {
        int[] stk = data[stackNum];
        int loc = locations[stackNum];
        if (loc < stk.length) {
            stk[loc] = value;
            locations[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        int[] stk = data[stackNum];
        int loc = locations[stackNum];
        if (loc > 0) {
            int val = stk[loc - 1];
            locations[stackNum]--;
            return val;
        } else {
            return -1;
        }
    }

    public int peek(int stackNum) {
        int[] stk = data[stackNum];
        int loc = locations[stackNum];
        if (loc > 0) {
            return stk[loc - 1];
        } else {
            return -1;
        }
    }

    public boolean isEmpty(int stackNum) {
        return locations[stackNum] == 0;
    }

}
