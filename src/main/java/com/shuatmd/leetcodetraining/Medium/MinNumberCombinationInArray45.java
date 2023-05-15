package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

//剑指 Offer 45. 把数组排成最小的数
//
public class MinNumberCombinationInArray45 {
    //解法2:用快排实现arrays.sort
    public void quickSort(String[] s, int l, int r) {
        l = 0;
        r = s.length - 1;
        int i = l;
        int j = r;
        if (l >= r) {
            return;
        }
        String tmp = s[i];
        while (i < j) {
            while ((s[i] + s[j]).compareTo(s[j] + s[i]) >= 0 && i < j) {
                j--;
            }
            while ((s[i] + s[j]).compareTo(s[j] + s[i]) <= 0 && i < j) {
                i++;
            }
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        s[i] = s[l];
        s[l] = tmp;
        quickSort(s, l, i - 1);
        quickSort(s, i + 1, r);
    }

    //解法1:用Array.sort将问题转化成排序问题解决(不推荐)
    public String minNumber(int[] nums) {
        //先将int数组转换成string数组存储
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        //通过arrays.sort自定义comparator来排序
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            res.append(string);
        }
        return res.toString();
    }
}
