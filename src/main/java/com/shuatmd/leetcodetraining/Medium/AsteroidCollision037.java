package com.shuatmd.leetcodetraining.Medium;

import java.util.Stack;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-09 16:17
 * @Description: TODO
 * @Version: I.0
 */
public class AsteroidCollision037 {
    //手搓解法1： 偷一下题解的思路 用stack来实现
    //难点在于判断stack什么时候可以加新的一个数,以及怎么实现爆炸
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < asteroids.length) {
            //判断stack什么时候可以添加当前位数的三个条件
            //1. 栈为空,
            //2. 栈顶为负数 (无论添加什么数字都不会相撞)
            //3. 当前位数为正 (栈顶为正则同向,为负则一左一右 都不会触发相撞)
            if(stack.isEmpty() || stack.peek() < 0 || asteroids[i] > 0){
                stack.push(asteroids[i]);
            }
            //只有stack顶为正,插入数为负时需要判断是否相撞
            //检查是否插入数的绝对值大于stack的顶
            //如果小于 则不插入 例子[5,10,-5] -> [5, 10]
            //如果等于 则pop 例子[5,10,-10]  -> [5]
            //如果大于 则pop当前的栈顶元素 并且一直pop直到栈为空或者栈中数字比他大
            else if(stack.peek() <= -asteroids[i]){
                if(stack.pop() < -asteroids[i]){
                    continue;
                }
            }
            i ++;
        }
        int[] ret = new int[stack.size()];
        for (int j = ret.length - 1; j >= 0; j--) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}
