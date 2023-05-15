package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//剑指 Offer II 007. 数组中和为 0 的三个数
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//你返回所有和为 0 且不重复的三元组。
public class ThreeSumEqualZero006 {
    //优化排序：不需要使用Set转List的操作,节约O(n)
    public List<List<Integer>> threeSumAdvanced(int[] nums) {
        //O(nlogn)
        Arrays.sort(nums);
        List<List<Integer>> resultList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //排序之后,如果i指向的数字与i - 1 相等 则直接continue
            //如果再跑一遍会得到相同的结果
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //双指针优化三步循环O(n^3) -> 到O(n^2)
            int l = i + 1;
            int r = nums.length -1;
            while(l < r){
                if (nums[l] + nums[r] == - nums[i]){
                    resultList.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //去重且需要继续查
                   while(l < r && nums[l] == nums[++l]);
                   while(l < r && nums[r] == nums[--r]);
                }
                else  if (nums[l] + nums[r] < - nums[i]){
                    l ++;
                }
                else{
                    r --;
                }
            }
        }
        return resultList;
    }
    //解法1：首先将list从低到高排序 耗费时间O(nlogn)
    //排序之后,固定一位数,将问题转换成双指针求和
    public List<List<Integer>> threeSum(int[] nums) {
        //O(nlogn)
        Arrays.sort(nums);
        Set<List<Integer>> resultList = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length -1;
            while(l < r){
                if (nums[l] + nums[r] == - nums[i]){
                    resultList.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //去重且需要继续查
                    l ++;
                    r --;
                }
                else  if (nums[l] + nums[r] < - nums[i]){
                    l ++;
                }
                else{
                    r --;
                }
            }
        }
        //Set转换List需要O(n) -> 可以优化
        return new ArrayList<>(resultList);
    }
}
