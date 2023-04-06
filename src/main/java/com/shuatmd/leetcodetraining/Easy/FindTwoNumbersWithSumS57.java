package com.shuatmd.leetcodetraining.Easy;
//剑指 Offer 57. 和为s的两个数字
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
public class FindTwoNumbersWithSumS57 {
    //用双指针来做.左右指正i,j指向nums的左右边界
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length -1;
        while (i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                return new int[]{nums[i],nums[j]};
            } else if (sum < target) {
                i ++;
            }
            else{
                j --;
            }
        }
        return new int[0];
    }
}
