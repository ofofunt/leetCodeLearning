package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

//面试题 16.06. 最小差
//给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
//https://leetcode.cn/problems/smallest-difference-lcci/description/
public class SmallestDiff1606 {
    //手搓解法1： 考虑将a,b排序之后 用双指针的办法来做
    //指针a指向a中的数 指针b指向b中的数
    //计算完绝对值差之后 将较小的数的指针后移 继续计算
    public int smallestDifference(int[] a, int[] b) {
        int lengthA = a.length;
        int lengthB = b.length;
        int pointerA = 0;
        int pointerB = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        //存在超过int.Max_VALUE的情况 需要用long来进行计算
        long ans = Long.MAX_VALUE;
        while (pointerA < lengthA && pointerB < lengthB) {
            long aa = a[pointerA];
            long bb = b[pointerB];
            long tmp = Math.abs(aa - bb);
            if (aa > bb) {
                pointerB++;
            } else {
                pointerA++;
            }
           ans = Math.min(ans,tmp);
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        SmallestDiff1606 smallestDiff1606 = new SmallestDiff1606();
        smallestDiff1606.smallestDifference(new int[]{-2147483648}, new int[]{2147483647});
    }
}
