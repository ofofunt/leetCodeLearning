package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

//面试题 10.11. 峰与谷
//在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
//例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
//https://leetcode.cn/problems/peaks-and-valleys-lcci/
public class WiggleSort1011 {
    //官方解法1：
    //通过手搓部分的解法 我们可以将3 5 1 2 6 4 sort成 1 2 3 4 5 6
    //再根据之前的算法来排列成 6 1 5 2 4 3
    //通过观察我们可以发现1 2 3或者 6 5 4的位置其实可以任意改变
    //得出结论：不需要保持整个数组有序,只需要保持数组的一半部分有序
    //将最小的len/2个数先排列好 之后顺序插入数即可
    //举例  1 x 2 x 3 x  -> x可以为4 5 6中的任何一个数
    public void wiggleSortOfficial(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int i = 0;
        int len = nums.length;
        int index = 0;
        //返回void 需要在原数组上进行修改 所以copy一个原数组
        int[] copy = Arrays.copyOf(nums, len);
        //如果数组个数少于3个 不需要重新排序
        if (len < 3) {
            return;
        }
        //首先将前半截数组放入priorityQueue
        for (; i < len / 2; i++) {
            priorityQueue.offer(copy[i]);
        }
        for (; i < len; i++) {
            priorityQueue.offer(copy[i]);
            nums[index] = priorityQueue.poll();
            index +=2;
        }
        index = 1;
        for (Integer integer : priorityQueue) {
            nums[index] = integer;
            index += 2;
        }
    }

    //手搓尝试： 分类讨论 如果长度是奇数 先放入最后一位与第一位,然后放入中间以为 之后无限放入最后一位和第一位
    //如果是偶数 则直接先放最后一位 再放第一位 循环执行
    //思路是对的 但是记得void的时候需要先arrayCopy出来一个 再对原数组进行修改
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (left <= right) {
            res[i] = nums[right];
            if (i < nums.length - 1) {
                res[++i] = nums[left];
            }
            i++;
            left++;
            right--;
        }
        nums = res;
    }

    public static void main(String[] args) {
        WiggleSort1011 wiggle = new WiggleSort1011();
        wiggle.wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
    }
}
