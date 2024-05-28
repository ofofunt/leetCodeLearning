package com.shuatmd.leetcodetraining.Hard;

import java.util.Arrays;

//321. 拼接最大数
//给你两个整数数组 nums1 和 nums2，它们的长度分别为 m 和 n。数组 nums1 和 nums2 分别代表两个数各位上的数字。同时你也会得到一个整数 k。
//
//请你利用这两个数组中的数字中创建一个长度为 k <= m + n 的最大数，在这个必须保留来自同一数组的数字的相对顺序。
//
//返回代表答案的长度为 k 的数组。
//
// https://leetcode.cn/problems/create-maximum-number/description/
public class MaxNumber321 {
    //官方题解： 分治 + 贪心
    //本体与RemoveKDigits402类似 但是区别为需要使用两个数组
    //可以用分治解法来解决 2个子问题其实为 分别从两个数组中取出 k1,k2个最大的数
    //之后再合并的时候将这k1 + k2 = k个数继续排序
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[k];
        Arrays.fill(res, 0);
        for (int i = 0; i <= n; i++) {
            if (k - i > m) continue;
            if (i > k) break;
            res = max(res, merge(kNum(nums1, i), kNum(nums2, k - i)));
        }
        return res;
    }

    public int[] kNum(int[] nums, int k) {
        // remove: 剩下需要移除的元素个数
        // index: 下一个需要填入 res 的索引
        int n = nums.length, remove = n - k, index = 0;
        int[] res = new int[n];
        for (int num : nums) {
            while (remove > 0 && index > 0 && num > res[index - 1]) {
                remove--;
                index--;
            }
            res[index++] = num;
        }
        return Arrays.copyOf(res, k);
    }

    public int[] max(int[] nums1, int[] nums2) {
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            if (nums2[i] > nums1[i]) return nums2;
            if (nums2[i] < nums1[i]) return nums1;
        }
        return nums1;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, l = n + m;
        int[] res = new int[l];
        int i = 0, j = 0;
        for (int k = 0; k < l; k++) {
            int a = i >= n ? -1 : nums1[i];
            int b = j >= m ? -1 : nums2[j];
            if (a > b) {
                res[k] = a;
                i++;
            } else if (b > a) {
                res[k] = b;
                j++;
            } else {
                String s1 = str(nums1, i);
                String s2 = str(nums2, j);
                if ((s1 + s2).compareTo(s2 + s1) > 0) {
                    res[k] = a;
                    i++;
                } else {
                    res[k] = b;
                    j++;
                }
            }
        }
        return res;
    }

    public String str(int[] nums, int i) {
        // return  ''.join(nums[i:])
        if (i >= nums.length) return "";
        StringBuilder sb = new StringBuilder();
        for (; i < nums.length; i++) {
            sb.append((char) (nums[i] + 'a'));
        }
        return sb.toString();
    }
}
