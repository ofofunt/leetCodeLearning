package com.shuatmd.leetcodetraining.Medium;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer II 011. 0 和 1 个数相同的子数组
//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
public class FindMaxLengthSubArrayBalanced011 {
    //官方解法1: 前缀和
    //解决sum为0或者不为0的方法, 初始化map 插入(0, -1)
    //若当前结果为0则说明 i到0为是一个0 , 1数量相同的解
    public int findMaxLengthOfficial(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int count = 0;
        //初始化 -1
        countMap.put(count, -1);
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                count ++;
            }
            else{
                count --;
            }
            if(countMap.containsKey(count)){
                maxLength = Math.max(maxLength, i - countMap.get(count));
            }
            else{
                countMap.put(count, i);
            }
        }
        return maxLength;
    }
    //手搓解法1：速度太低
    //疑问: sum为0的时候需要单独处理,sum不为0则需要保持放入map的index为最低值
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0? -1:nums[i];
           if(map.get(0 + sum) != null){
               maxLength = Math.max(maxLength,i - map.get(0 + sum) + 1);
               continue;
           }
           else if(sum == 0) {
               maxLength = Math.max(maxLength, i + 1);
               continue;
           }
               map.put(sum, map.getOrDefault(sum,i + 1));
        }
        return Math.max(maxLength,map.getOrDefault(0,0));
    }
}
