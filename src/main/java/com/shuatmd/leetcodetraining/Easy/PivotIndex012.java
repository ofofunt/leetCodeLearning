package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;

//剑指 Offer II 012. 左右两边子数组的和相等
//给你一个整数数组 nums ，请计算数组的 中心下标 。
//
//数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
//
//如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
//
//如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
public class PivotIndex012 {
    //官方解法1:前缀和解法 更优雅 不用考虑左右边界
    // 时间复杂度O(n) 空间复杂度O(1)
    public int pivotIndexOfficial(int[] nums) {
        //假设左边的总和为sum 此时右边的和为total - sum - nums[i]
        //如果左右相等 则存在 sum = total - sum - nums[i]
        //2 * sum + nums[i] = total
        int sum = 0;
        int total = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if(2 * sum + nums[i] == total){
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
    //手搓解法1: 先求出右边的和 然后循环移动pivot指针
    //移动时叠加左边的和 递减右边的和 直到两边相等
    //缺点: 右边界处理不优雅
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        for (int j = 0; j < nums.length; j++) {
            if(leftSum == rightSum){
                return j;
            }
            leftSum += nums[j];
            rightSum -= (j + 1 < nums.length)? rightSum : nums[j + 1];
        }
        return -1;
    }
}
