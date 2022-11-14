package com.shuatmd.leetcodetraining.Hard;

import java.util.Stack;

public class CheckValidateStackPopSequence31 {
    //Solution1: 运用辅助栈解决

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        //对于pushed数组循环，把每个数字都push到辅助栈stack之中
        for(int num : pushed){
            //把当前数字push到stack之中
            stack.push(num);
            //循环判断是否当前stack的顶部数字与需要被pop的数字相等，如果相等则pop
            //pop之后i+1 取下一个需要pop的数字 循环判断
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i ++;
            }
        }
        //如果整个辅助栈可以被清空，则表明是valid
        return stack.isEmpty();
    }

    //Solution 2:运用双指针模拟辅助栈解决


    public static void main(String[] args) {
        CheckValidateStackPopSequence31 checkValidateStackPopSequence31 = new CheckValidateStackPopSequence31();
        int[] pushed = new int[]{1,2,3,4,5};
        int[] poped = new int[]{4,5,3,2,1};
        int[] poped2 = new int[]{4,3,5,1,2};
        System.out.println(checkValidateStackPopSequence31.validateStackSequences(pushed,poped2));
    }
}
