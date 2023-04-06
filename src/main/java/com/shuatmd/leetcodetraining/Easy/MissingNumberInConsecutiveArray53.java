package com.shuatmd.leetcodetraining.Easy;
//剑指 Offer 53 - II. 0～n-1中缺失的数字
//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
// 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
public class MissingNumberInConsecutiveArray53 {
    //用二分法来做,定义左右边框i,j 中位数m = (i + j)/2
    // 二分比较当前nums的index m与nums[m]的大小
    //m > num[m]的情况不会出现
    //m = num[m]说明缺失的数字在[m + 1, j]
    //m < num[m]说明缺失的数字在[i, m -1]
    //循环跳出时,i指向的右子数组的第一个元素,j指向的是左子数组的末尾元素
    //返回i
    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int m = 0;
        while(i <= j){
            m = (i + j)/2;
            if(m == nums[m]){
                i = m + 1;
            }
            else{
                j = m -1;
            }
        }
        return i;
    }
}
