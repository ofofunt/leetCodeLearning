package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//347. 前 K 个高频元素
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//https://leetcode.cn/problems/top-k-frequent-elements/description/
public class TopKFrequent347 {
    //手搓解法1： 官方建议用PriorityQueue 尝试直接sort
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(countMap.entrySet());
        //sort耗时过长 不如直接用PriorityQueue
        Collections.sort(entries,(a,b) ->{
            return b.getValue() - a.getValue();
        });
        for (int i = 0; i < k; i++) {
            res[i] = entries.get(i).getKey();
        }

        return res;
    }
}
