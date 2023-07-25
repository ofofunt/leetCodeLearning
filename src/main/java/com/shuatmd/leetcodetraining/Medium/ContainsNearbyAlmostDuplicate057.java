package com.shuatmd.leetcodetraining.Medium;

import java.util.TreeSet;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-17 14:53
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 057. 值和下标之差都在给定的范围内
//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
//
//如果存在则返回 true，不存在返回 false。

public class ContainsNearbyAlmostDuplicate057 {
    //官方解法1：滑动窗口 + treeSet
    //滑动窗口解决下标i,j的间隔问题
    //treeSet有序数列解决abs(num[i] = nums[j]) <= t的问题
    //分两种情况对比 nums[i] - nums[j] <= t && nums[j] - nums[i] <= t
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //new一个新的treeSet来作为滑动窗口的容器
        TreeSet<Long> temp = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //找出等于或者大于nums[i] - t的数
            //满足 nums[i] - t <= ceil -> nums[i] - ceil <= t
            Long ceil = temp.ceiling((long)nums[i] - (long) t);
            //ceil - nums[i] < = t
            if(ceil != null && ceil <= (long) t + (long) nums[i]) {
                return true;
            }
            temp.add((long) nums[i]);
            //滑动窗口判断是否size<= k
            if(i >= k){
                temp.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
