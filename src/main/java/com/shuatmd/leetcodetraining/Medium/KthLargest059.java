package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-18 15:45
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 059. 数据流的第 K 大数值
//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
//
//请实现 KthLargest 类：
//
//KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
//int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
public class KthLargest059 {
    Queue<Integer> queue = new PriorityQueue<Integer>();
    int index;

    public KthLargest059(int k, int[] nums) {
        index = k;
        Arrays.sort(nums);
        for (int i = 1; i < k; i++) {
            queue.add(nums[nums.length - i]);
        }
        if(k > nums.length){
            queue.offer(Integer.MIN_VALUE);
        }
        else{
            queue.offer(nums[nums.length - k]);
        }

    }

    public int add(int val) {
        queue.add(val);
        queue.poll();
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest059 kthLargest059 = new KthLargest059(2, new int[]{0});
        kthLargest059.add(-1);
        kthLargest059.add(1);
        kthLargest059.add(-2);
        kthLargest059.add(-4);
        kthLargest059.add(-3);

    }
}


