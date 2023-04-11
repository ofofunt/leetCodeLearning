package com.shuatmd.leetcodetraining.Hard;

import java.util.*;

public class MaxIntInSlidingWindow59 {
    //官方解法1：使用单调队列来记录滑动窗口的情况,每次滑动之后取最大值的消耗为O(1)
    public int[] maxSlidingWindowOfficial(int[] nums, int k) {
        //单调队列
        //下面是要注意的点：
        //队列按从大到小放入
        //如果首位值（即最大值）不在窗口区间，删除首位
        //如果新增的值小于队列尾部值，加到队列尾部
        //如果新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
        //如果新增值大于队列中所有值，删除所有，然后把新增值放到队列首位，保证队列一直是从大到小
        if(nums.length == 0){
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        //初始化最初的滑动窗口,将其中的值单调排序
        for (int i = 0; i < k; i++) {
            //如果添加的值大于尾部的值,则删除尾部
            //一直循环,如果大于目前deque中的所有值,则删除所有值
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            //如果要加入的值小于当前deque中最小(最末尾的值),则添加到末尾
            deque.addLast(nums[i]);
        }
        result[index++] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            //判断如果上一个滑动窗口的最大值是否需要被移除
            //如果当前deque的最大值与上一个滑动窗口的最左边的值相同,则需要移除
            if(deque.peekFirst() == nums[i - k]){
                deque.removeFirst();
            }
            //和上面一样的逻辑
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            result[index++]  = deque.peekFirst();
        }
        return result;
    }
    //稍微改进过用优先队列的写法：O(nlogk)
    public int[] maxSlidingWindowPriorityQueue(int[] nums, int k) {
        //初始化优先队列以及comparator
        Queue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> {return o2 - o1;});
        int[] result = new int[nums.length - k + 1];
        //初始化最初的滑动窗口到queue中
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        //初始化第一次滑动窗口的结果
        //可以把这一步融合到下面的循环之中简化操作,但是为了清晰单独提出来
        //for (int j = 0; j < result.length; j++) {
        //            //每往后滑动一次,添加新加入的数字,再用peek取出当前数中的最高数
        //            queue.offer(nums[j + k - 1]);
        //            result[j] = queue.peek();
        //            queue.remove(nums[j]);
        //        }
        result[0] = queue.peek();
        queue.remove(nums[0]);
        for (int j = 1; j < result.length; j++) {
            //每往后滑动一次,添加新加入的数字,再用peek取出当前数中的最高数
            queue.offer(nums[j + k - 1]);
            result[j] = queue.peek();
            queue.remove(nums[j]);
        }
        return result;
    }
    //不考虑runningtime的暴力写法： O(nk)
    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            //记得存在负数,用Math.max取最大值时要给max一个默认的最小值
            int max = - Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            result[i] = max;
        }
        return result;
    }
}
