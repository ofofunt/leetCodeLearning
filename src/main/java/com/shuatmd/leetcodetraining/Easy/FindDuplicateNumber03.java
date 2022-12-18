package com.example.leetCodeLearning.src.main.java.com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateNumber03 {
    /*Solution 1
     * 运用HashSet 添加失败则代表hashSet中存在当前元素，为重复
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        int res = -1;
        for (int num : nums) {
            if (!numsSet.add(num)) {
                res = num;
                break;
            }
        }
        return res;
    }

    /*Solution 2
     * Sort之后对比i与i+ 遍历完整个list之后就知道重复的部分
     */
    public static int findRepeatNumber2(int[] nums) {
        int res = -1;
        List<Integer> integers = Arrays.stream(nums).sorted().boxed().toList();
        for (int i = 0; i < nums.length - 1; i++) {
            if (integers.get(i).equals(integers.get(i + 1))) {
                res = integers.get(i);
                return res;
            }
        }
        return res;
    }


    public static int findRepeatNumber3(int[] nums) {
        int n = nums.length;
        int res = -1;
        for (int num : nums) {
            if (num < 0 || num > n) {
                return res;
            }
        }
        for (int i = 0; i < n; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return res;
}

    private static void swap(int[] nums, int num, int index) {
        int temp = nums[num];
        nums[num] = nums[index];
        nums[index] = temp;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber2 = findRepeatNumber3(nums);
    }
}
