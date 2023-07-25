package com.shuatmd.leetcodetraining.Medium;

import java.util.PriorityQueue;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-18 17:06
 * @Description: TODO
 * @Version: I.0
 */
public class KthLargest059Advanced {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest059Advanced(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest059Advanced kth = new KthLargest059Advanced(4, new int[]{4,5,2,8});
        kth.add(3);
        kth.add(5);
        kth.add(10);
        kth.add(9);
        kth.add(4);
    }
}
