package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

//面试题 16.16. 部分排序
//给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
//注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
//https://leetcode.cn/problems/sub-sort-lcci/
public class SubSort1616 {
    //简单理解且快速的官方解法2：三次遍历
    //首先从左往右遍历 记下第一个左边比右边大的数为m
    //再次从右往左遍历 记下第一个左边比右边大的数为n
    //第三次遍历对滑动窗口mn的大小进行调整
    public int[] subSort3(int[] array) {
        //当array长度小于2时,不存在重新排序,直接返回-1 -1
        int len = array.length;
        if (len < 2) {
            return new int[]{-1, -1};
        }
        //找到左右的2个反常的点
        int i = 0;
        while (i < len - 1 && array[i] <= array[i + 1]) {
            ++i;
        }
        int j = len - 1;
        while (j > 0 && array[j] >= array[j - 1]) {
            j--;
        }

        if (j < i) {
            return new int[]{-1, -1};
        }
        int m = i;
        int n = j;
        //将【m...n】看作一个【窗口】，接下来我们需要调整这个窗口的大小，调整策略如下：
        //
        //如果窗口中，出现比m前一个数字小的数字，需要把窗口的左边界往左扩大
        //如果窗口中，出现比n后一个数字大的数字，需要把窗口的右边界往右扩大
        //循环往复，最后即为最小窗口。
        for (int k = i; k <= j; k++) {
            while (m > 0 && array[k] < array[m - 1]) {
                m--;
            }
            while (n > 0 && array[k] > array[n + 1]) {
                n++;
            }
        }

        return new int[]{m, n};
    }

    //简单理解的官方解法1：双指针+2次遍历
    //首先正向遍历 遍历中记录当序数列中最大值max 如果当前指针小于max 则记下index 遍历完之后可以保证指针last右边的所有数都是升序
    //然后逆向遍历 遍历中记录降序数列中最小值min 如果当前指针大于min 则记下index 遍历完之后保证指针first左边的所有数都是降序
    //此方法可以保证中间段落排序之后不会出现
    public int[] subSort2(int[] array) {
        //当array长度小于2时,不存在重新排序,直接返回-1 -1
        if (array.length < 2) {
            return new int[]{-1, -1};
        }
        int length = array.length;
        int first = -1;
        int last = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (array[i] < max) {
                last = i;
            } else {
                max = array[i];
            }
            if (array[length - 1 - i] > min) {
                first = length - 1 - i;
            } else {
                min = array[length - 1 - i];
            }
        }
        return new int[]{first, last};
    }

    //手搓解法1： 土味方法 先sort 然后对比
    //双指针一个指向开头 一个指向分段结尾
    //尽然能成 额
    public int[] subSort(int[] array) {
        int len = array.length;
        if (len <= 1) {
            return new int[]{-1, -1};
        }
        int[] copy = Arrays.copyOf(array, len);
        Arrays.sort(copy);
        int left = 0;
        int right = 0;
        int leftCheck = 0;
        for (int i = 0; i < len; i++) {
            if (copy[i] != array[i]) {
                if (leftCheck == 0) {
                    left = i;
                    leftCheck++;
                } else {
                    right = i;
                }
            }
        }
        return left == 0 && right == 0 ? new int[]{-1, -1} : new int[]{left, right};
    }
}
