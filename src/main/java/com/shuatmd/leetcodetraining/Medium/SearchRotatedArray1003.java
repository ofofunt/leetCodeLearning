package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;

//面试题 10.03. 搜索旋转数组
//搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
//https://leetcode.cn/problems/search-rotate-array-lcci/
public class SearchRotatedArray1003 {
    //官方解法1：正统做法：二分法解决
    public int searchOfficial(int[] arr, int target) {
        //特殊情况 第一位与target相同
        //因为是优先搜索右半边,所以如果左边存在结果,则需要优先判断
        if(arr[0]==target) {
            return 0;
        }
        int length = arr.length;
        int left = 0;
        int right = length - 1;
        int mid = 0;
        //开始二分查找
        while (left <= right) {
            mid = left + (right - left) / 2;
            //因为可能存在多个相同元素,如果目标与当前mid相等,仍然需要向左寻找
            if (arr[mid] == target) {
                while (mid > 0 && arr[mid - 1] == arr[mid]) {
                    mid--;
                }
                return mid;
            }
            //如果mid小于right对应的数,则说明右半边为递增数组
            if (arr[mid] < arr[right]) {
                //判断target大小与右侧的递增数组相比,
                //如果arr[mid] < target < arr[right]
                //继续在区间[mid + 1, r)内寻找
                //如果target < arr[mid]
                //则在区间arr[left,mid - 1)中查找
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                //如果arr[mid]大于arr[right]说明左边为递增 右边已经有rotate过得数
            } else if (arr[mid] > arr[right]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //如果arr[mid] == arr[right] 则说明右边可以胜率
            else {
                right--;
            }

        }
        return -1;
    }

    //土味解法：直接转list之后轮询去找
    public int search(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        if (list.contains(target)) {
            for (int i = 0; i < list.size(); i++) {
                if (target == list.get(i)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
