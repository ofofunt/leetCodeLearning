package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;

//面试题 10.01. 合并排序的数组
//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//
//初始化 A 和 B 的元素数量分别为 m 和 n。
public class MergeTwoArrays1001 {
    //官方解法2： 双指针
    //通过从后向前遍历可以不使用临时变量,直接完整修改A
    public void merge(int[] A, int m, int[] B, int n) {
        int a = m - 1;
        int b = n - 1;
        int tail = m + n - 1;
        int cur = 0;
        while(a >= 0 || b>=0){
            if(a == -1){
                cur = B[b--];
            } else if (b == -1) {
                cur = A[a--];
            } else if (A[a] > B[b]) {
                cur = A[a--];
            }
            else{
                cur = B[b--];
            }
            A[tail--] = cur;
        }
    }

    //手搓解法1： 合并到最后 然后直接sort
    //缺点：没有用到两个数组都已经排好序的条件,实际上还需要额外再做一轮排序
    public void mergeHand(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 0, 0, 0, 0};
        int[] B = {2, 5, 6, 7};
        MergeTwoArrays1001 merge = new MergeTwoArrays1001();
        merge.merge(A, 4, B, 4);
    }
}
