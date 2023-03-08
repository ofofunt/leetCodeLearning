package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement39 {
    //排序法
    //因为出现数量大于nums长度的一半,所以排序之后的中间数一定是出现次数最多的数
    public int majorityElementSortMethod(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //Hashmap法,用HashMap来记录数字以及数字出现的次数,遍历玩num[]之后通过次数来选最多
    public static int majorityElementHashMapMethod(int[] nums) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(nums[i])) {
                resultMap.put(nums[i], resultMap.get(nums[i]) + 1);
            } else {
                resultMap.put(nums[i], 1);
            }
        }
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : resultMap.entrySet()) {
            if (maxEntry == null || integerIntegerEntry.getValue() > maxEntry.getValue()) {
                maxEntry = integerIntegerEntry;
            }
        }
        return maxEntry.getKey();
    }

    //摩尔投票法
    public static int majorityElementHashMapVote(int[] nums) {
        int mod = 0;
        int vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                mod = num;
            }
            vote += num == mod ? 1 : -1;
        }
        return mod;

    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int i = MajorityElement39.majorityElementHashMapMethod(nums);
    }
}

