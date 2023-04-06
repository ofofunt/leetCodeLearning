package com.shuatmd.leetcodetraining.Easy;

//剑指 Offer 53 - I. 在排序数组中查找数字 I
//统计一个数字在排序数组中出现的次数。
public class SearchApearTimesInSortedArray53 {
    //解法：使用二分法来找到左右的边界
    //因为是排序好的array 所以通过右边界 - 左边界 - 1 就可以得到出现次数
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        //首先寻找出右区间
        while(l <= r){
            //算出中间的位数
            int m = (l + r)/2;
            //如果当前位数的数字小于target 说明target在[m+1, j]这个区间
            //如果当前位数等于target 为了找到右区间 我们要继续让l = m + 1 因为右区间在[m+1 ,j]这个区间
            //简单理解就是找到target右边第一个比target大的数
            //结束循环时l指向的是比target大的第一个数, 也就是右边界
            //r指向的是target,如果没有target则指向比target小的数
            if(nums[m] <= target){
                l = m + 1;
            } else if (nums[m] > target) {
                r = m -1;
            }
        }
        int right = l;
        //判断target是否存在,如果不存在则直接返回0
        //记得先判断r是否大于0 防止indexOutOfBound
        if(r >= 0 && nums[r] != target){
            return 0;
        }
        //重置两个指针
        l = 0;
        r = nums.length -1;
        //找出左边框
        while(l <= r){
            //算出中间的位数
            int m = (l + r)/2;
            //如果当前位数的数字小于target 说明target在[m+1, j]这个区间
            //如果当前位数等于target 为了找到左区间 我们要继续让r = m -1 因为左边框在[i. m-1]这个范围内
            //简单来说就是找到target左边第一个比target小的数
            //结束循环时l指向的是比target大的第一个数, 也就是右边界
            //r指向的是target,如果没有target则指向比target小的数
            if(nums[m] < target){
                l = m + 1;
            } else if (nums[m] >= target) {
                r = m -1;
            }
        }
        int left = r;
        return right - left -1;
    }
}
