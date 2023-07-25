package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//剑指 Offer II 061. 和最小的 k 个数对
//给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
//
//定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
//
//请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
public class KSamllestPairs061 {


    public List<List<Integer>> kSmallestPairsAdvanced(int[] nums1, int[] nums2, int k) {
        int l = nums1.length;
        int r = nums2.length;
        if (l < 1 || r < 1) {
            return null;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] + o2[1] - o1[0] - o1[1];
            }
        });
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                if (queue.size() < k) {
                    queue.offer(new int[]{nums1[i], nums2[j]});
                } else {
                    int sum = nums1[i] + nums2[j];
                    int[] peek = queue.peek();
                    int peekSum = peek[0] + peek[1];
                    if (sum < peekSum) {
                        queue.poll();
                        queue.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (int[] ints : queue) {
            resultList.add(Arrays.asList(ints[0], ints[1]));
        }
        return resultList;
    }

    //手搓解法：使用priorityQueue来存所有结果并且排出所有结果
    //缺点： 排列组合用时长,可以考虑修改为维护k个长度的窗口
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int l = nums1.length;
        int r = nums2.length;
        if (l < 1 || r < 1) {
            return null;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                queue.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        int size = queue.size();
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (i < size) {
                int[] poll = queue.poll();
                resultList.add(Arrays.asList(poll[0], poll[1]));
            }
        }
        return resultList;
    }

}
