package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.List;

//349. 两个数组的交集
//给定两个数组 nums1 和 nums2 ，返回 它们的
//交集
// 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//https://leetcode.cn/problems/intersection-of-two-arrays/description/
public class Intersection349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] count1 = new int[1001];
        int[] count2 = new int[1001];
        List<Integer> res = new ArrayList<>();
        for (int i : nums1) {
            count1[i] += 1;
        }
        for (int i : nums2) {
            count2[i] += 1;
        }
        for (int i = 0; i < 1001; i++) {
            if(count1[i] > 0 && count2[i] > 0){
                res.add(i);
            }
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
