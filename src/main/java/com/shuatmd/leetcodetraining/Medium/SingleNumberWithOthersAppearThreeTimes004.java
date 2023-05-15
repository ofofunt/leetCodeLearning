package com.shuatmd.leetcodetraining.Medium;
//剑指 Offer II 004. 只出现一次的数字
//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。

import java.util.HashMap;
import java.util.Map;

public class SingleNumberWithOthersAppearThreeTimes004 {
    //解法1：哈希表遍历 时间复杂度O(n) 空间复杂度O(n)
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            //用getOrDefault来做次数的存储,省略判断
                countMap.put(nums[i],countMap.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == 1){
                res = entry.getKey();
            }
        }
        return res;
    }

    //解法2:数学解法 将所有数字转换为二进制
    //二进制所有位数的和整除于3的余数则为需要的数
    public int singleNumberMath(int[] nums) {
        int[] sum = new int[32];
        int res = 0;
        //遍历nums获取所有位数的和
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                sum[i] += num&1;
                num = num >>> 1;
            }
        }
        //将所有位数的和整除3取余
        for (int i = 0; i < sum.length; i++) {
            sum[i] %= 3;
        }
        for (int i = 0; i < sum.length; i++) {
            res <<= 1;
            res |= sum[31 - i];
        }
        return res;
    }
}
