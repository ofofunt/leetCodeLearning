package com.shuatmd.leetcodetraining.Easy;

//面试题 08.03. 魔术索引
//魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，
//若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
//https://leetcode.cn/problems/magic-index-lcci/
public class FindMajicIndex0803 {
    //手搓解法2：跳跃查询
    public int findMagicIndex2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; ) {
            if (nums[i] == i) {
                return i;
            }
            i = Math.max(i + 1, nums[i]);
        }
        return -1;
    }

    //手搓解法1：暴力
    public int findMagicIndex(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
