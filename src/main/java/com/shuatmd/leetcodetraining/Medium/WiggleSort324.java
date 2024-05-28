package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

//324. 摆动排序 II
//给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
//
//你可以假设所有输入数组都可以得到满足题目要求的结果。
//https://leetcode.cn/problems/wiggle-sort-ii/description/
public class WiggleSort324 {
    //官方解法1：
    //轮流插入 + 反转排序
    //使用中线分解的方法 将数组分为2部分 比如  1 2 3 4 5 分为 1 2 3 和 4 5
    //然后进行轮流插入 变成1 4 2 5 3
    //特例 比如 1 1 2 2 2 3 分割之后变成 1 1 2/2 2 3 会出现1 2 1 2 2 3两个2相邻的情况
    //因为题目明确表示一定存在解,所以重复数字的个数最多为(length(nums) + 1)/2
    //为了解决这种场景 需要将序列分割之后翻过来
    //比如 1 1 2 2 2 3 分割后为 1 1 2/ 2 2 3 反转为 2 1 1/ 3 2 2
    //再次插入变成2 3 1 2 1 2
    public void wiggleSortOfficial(int[] nums) {
        Arrays.sort(nums);
        int[] firstHalf;
        int[] secondHalf;
        //需要分类讨论 如果长度是偶数 则直接分为2个等长的数组
        //如果长度是奇数,需要保证firstHalf更长
        if (nums.length % 2 == 0) {
            firstHalf = Arrays.copyOfRange(nums, 0, nums.length / 2);
            secondHalf = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
        } else {
            firstHalf = Arrays.copyOfRange(nums, 0, (nums.length / 2) + 1);
            secondHalf = Arrays.copyOfRange(nums, (nums.length / 2) + 1, nums.length);
        }
        int i = firstHalf.length - 1;
        int j = secondHalf.length - 1;
        int k = 0;
        //顺序轮流插入 不过需要保持倒序
        while (k < nums.length) {
            if (i >= 0) {
                nums[k] = firstHalf[i];
                k++;
                i--;
            }
            if (j >= 0) {
                nums[k] = secondHalf[j];
                k++;
                j--;
            }
        }
    }

    //手搓解法：
    //尝试了2中方法,一种是sort之后顺序+逆序轮流插入,会出现相同数字相邻的情况 无法解决
    //第二种是通过中线分割,之后轮流插入 同样无法解决
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int i = 0;
        int j = nums.length - 1;
        nums[0] = copy[copy.length / 2];
        for (int k = 1; k < nums.length; k++) {
            if (k % 2 != 0) {
                nums[k] = copy[i];
                i++;
            } else {
                nums[k] = copy[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        WiggleSort324 wiggle = new WiggleSort324();
        wiggle.wiggleSortOfficial(new int[]{1, 5, 1, 1, 6, 4});
    }
}
