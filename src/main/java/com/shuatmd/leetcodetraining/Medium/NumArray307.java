package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

//307. 区域和检索 - 数组可修改
//给你一个数组 nums ，请你完成两类查询。
//
//其中一类查询要求 更新 数组 nums 下标对应的值
//另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
//实现 NumArray 类：
//
//NumArray(int[] nums) 用整数数组 nums 初始化对象
//void update(int index, int val) 将 nums[index] 的值 更新 为 val
//int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
public class NumArray307 {
    int[] sums;
    int[] array;

    //手搓解法：暴力or前缀和 update耗时为O(n)/O(1) sumRange操作为O(1)/O(n) 会超时 需要使用树状解法
    //官方解法会写在NumArray307Official里面

    public NumArray307(int[] nums) {
        array = Arrays.copyOf(nums, nums.length);
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + array[i];
        }
    }

    public void update(int index, int val) {
        for (int i = index; i < sums.length; i++) {
            sums[i + 1] = sums[i + 1] - array[index] + val;
        }
        array[index] = val;
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }

    public static void main(String[] args) {
        NumArray307 num = new NumArray307(new int[]{1, 3, 5});
        num.update(1,2);
        num.sumRange(0,2);
    }
}
