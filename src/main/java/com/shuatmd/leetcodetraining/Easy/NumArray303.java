package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//303. 区域和检索 - 数组不可变
//计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
//实现 NumArray 类：
//
//NumArray(int[] nums) 使用数组 nums 初始化对象
//int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
//https://leetcode.cn/problems/range-sum-query-immutable/description/
public class NumArray303 {
    //前缀和来做 更快
    int[] sums;
    public NumArray303(int[] nums) {
        sums = new int[nums.length];
        int sum = 0;
        Arrays.fill(sums,0);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            sums[i] = sum;
        }
    }
    public int sumRange(int left, int right) {
        if(left == 0){
            return sums[right];
        }
        return sums[right] - sums[left - 1];
    }

    public static void main(String[] args) {
        NumArray303 num = new NumArray303(new int[]{-2,0,3,-5,2,-1});
        num.sumRange(0,2);
        num.sumRange(2,5);
        num.sumRange(0,5);
    }

    //手搓解法 List坐 会记录index 但是复杂化了
//    List<Integer> list = new ArrayList<>();
//    public NumArray303(int[] nums) {
//        for (int num : nums) {
//            list.add(num);
//        }
//    }
//
//    public int sumRange(int left, int right) {
//        int sum = 0;
//        for (int i = left; i <= right; i++) {
//            sum += list.get(i);
//        }
//        return sum;
//    }
}
