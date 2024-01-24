package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//面试题 16.24. 数对和
//设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
//https://leetcode.cn/problems/pairs-with-sum-lcci/
public class PairSums1624 {
    //官方解法2： 排序之后双指针
    public List<List<Integer>> pairSumsOfficial2(int[] nums, int target) {
        //对数组进行排序
        Arrays.sort(nums);

        List<List<Integer>> ans = new LinkedList<>();
        int left = 0, right = nums.length - 1;
        while (left < right) {
            //两个指针所指的两个元素和
            int sum = nums[left] + nums[right];
            //如果两个的和小于目标值，那么left指针向右走一步继续寻找
            if (sum < target)
                ++left;
                //如果两个的和大于目标值，那么right指针向左走一步继续寻找
            else if (sum > target)
                --right;
                //如果刚好等于要找的target值，那么加入结果集中，并且left指针和right指针分别向右和向左走一步(因为一个数只能属于一个数对)
            else
                ans.add(Arrays.asList(nums[left++], nums[right--]));

        }

        return ans;
    }

    //官方解法1： HashMap但是先判断顺序不同
    //官方的解法是先判断map中有没有 如果没有就把当前数放入 如果有则次数-1 或者移除 单循环
    public List<List<Integer>> pairSumsOfficial(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> resList = new ArrayList<>();
        for (int num : nums) {
            Integer count = map.get(target - num);
            if (count != null) {
                resList.add(Arrays.asList(num, target - num));
                if (count == 1) {
                    map.remove(target - num);
                } else {
                    map.put(target - num, --count);
                }
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return resList;
    }

    //手搓解法2：没优化多少
    public List<List<Integer>> pairSums2(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        //用HashMap记录下每个数字出现的个数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                map.put(num, count - 1);
                if (map.getOrDefault(target - num, 0) > 0) {
                    resList.add(Arrays.asList(num, target - num));
                    map.put(target - num, map.getOrDefault(target - num, 0) - 1);
                } else {
                    map.put(num, count);
                }
            }
        }
        return resList;
    }

    //手搓解法1：HashMap记录个数+匹配
    //判断太几把麻烦了 想一下别的思路
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        //用HashMap记录下每个数字出现的个数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (num != target - num && map.getOrDefault(num, 0) > 0) {
                int count = map.getOrDefault(target - num, 0);
                if (count > 0) {
                    resList.add(Arrays.asList(num, target - num));
                    map.put(target - num, count - 1);
                    map.put(num, map.getOrDefault(num, 0) - 1);
                }
            } else if (num == target - num && map.getOrDefault(num, 0) > 1) {
                int count = map.getOrDefault(target - num, 0);
                resList.add(Arrays.asList(num, target - num));
                map.put(target - num, count - 2);
            }
        }
        return resList;
    }
}
