package com.shuatmd.leetcodetraining.Medium;
//面试题 16.21. 交换和
//给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
//
//返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
//https://leetcode.cn/problems/sum-swap-lcci/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSwapValues1621 {
    //官方解法2： 双指针
    public int[] findSwapValuesDoublePointer(int[] array1, int[] array2) {
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        //如果算出来最后2者的
        if ((sum1 + sum2) % 2 != 0) {
            return new int[0];
        }
        int diff = sum1 - sum2;
        Arrays.sort(array1);
        Arrays.sort(array2);
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if ((array1[i] - array2[j]) * 2 == diff) {
                return new int[]{array1[i], array2[j]};
            } else if ((array1[i] - array2[j]) * 2 < diff) {
                i++;
            } else {
                j++;
            }
        }
        return new int[0];
    }

    //官方解法1：一个解法 通过HashSet来判断是否存在 可以将2^n问题转换到n*2
    public int[] findSwapValuesMath(int[] array1, int[] array2) {
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        int finalSum = (sum1 + sum2) / 2;
        //如果算出来最后2者的
        if ((sum1 + sum2) % 2 != 0) {
            return new int[0];
        }
        int diff = sum1 - sum2;
        Set<Integer> set = new HashSet<>();
        for (int i : array2) {
            set.add(i);
        }
        diff = diff / 2;
        for (int i : array1) {
            if (set.contains(i - diff)) {
                return new int[]{i, i - diff};
            }
        }
        return new int[0];
    }

    //手搓解法1： 求两个array的和sum1以及sum2 通过sum1 sum2来找到最后两个array相等的值
    //如果sum的差值为非整数,说明不可能通过交换来
    //两个array间的遍历n^2时间太长 考虑sort之后用双指针来找
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        int finalSum = (sum1 + sum2) / 2;
        //如果算出来最后2者的
        if ((sum1 + sum2) % 2 != 0) {
            return new int[0];
        }
        int diff = sum1 > sum2 ? sum1 - finalSum : sum2 - finalSum;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] - array2[j] == diff && sum1 > sum2) {
                    return new int[]{array1[i], array2[j]};
                } else if (array2[j] - array1[i] == diff && sum1 < sum2) {
                    return new int[]{array1[i], array2[j]};
                } else if (sum1 == sum2 && array1[i] == array2[j]) {
                    return new int[]{array1[i], array2[j]};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        FindSwapValues1621 swap = new FindSwapValues1621();
        swap.findSwapValuesDoublePointer(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});
    }

}
