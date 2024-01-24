package com.shuatmd.leetcodetraining.Easy;
//面试题 17.04. 消失的数字
//数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗
//https://leetcode.cn/problems/missing-number-lcci/description/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MissingNumber1704 {
    //官方解法2： 等差数列求和 再减去当前的和
    //不需要容器来进行查询以及放入元素
    public int missingNumberOfficial2(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += nums[i];
        }
        return total - arrSum;
    }

    //官方解法1： 可能更好地哈希解法
    //运用set来进行存储以及查找
    public int missingNumberOfficial(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    //手搓解法 先遍历放入HashMap中
    //再根据HashMap的key轮询查找
    public int missingNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int num : nums) {
            map.put(num, 1);
        }
        for (int i = 0; i < length + 1; i++) {
            if (map.get(i) == null) {
                return i;
            }
        }
        return -1;
    }
}
